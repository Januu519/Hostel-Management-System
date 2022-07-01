package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.bo.custom.impl.ReservationBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.bo.custom.impl.StudentBoImpl;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.Student;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewReservationFormController implements Initializable {

    public RadioButton maleBtn;
    public RadioButton femaleBtn;
    public Label lblGender;
    public RadioButton payNow;
    public RadioButton payLater;
    public AnchorPane newResevationContext;
    public ImageView homeBtn;
    public JFXTextField studentId;
    public JFXTextField studentName;
    public JFXTextField studentContact;
    public javafx.scene.control.DatePicker DatePicker;
    public JFXTextField studentAddress;
    public Label genderTxt;
    public JFXComboBox roomIdBox;
    public JFXTextField roomId;
    public JFXTextField keyMoney;
    public Button checkAvailable;
    public Button checkRoomBtn;
    public JFXTextField roomType;
    StudentBoImpl studentBoImpl = (StudentBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    ReservationBoImpl reservationBo = (ReservationBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    String gender;
    String status;


    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String sId = generateStudentId();
        studentId.setText(sId);

        loadAllId();

        roomIdBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String nwValue = (String) newValue;
            try {
                Room room = roomBoImpl.searchRoom(nwValue);
                roomType.setText(room.getRoomType());
                keyMoney.setText(room.getKeyMoney());
                String newResId = generateRoomId();
                roomId.setText(newResId);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    private String generateRoomId() throws SQLException, ClassNotFoundException, IOException {
        String rId = reservationBo.generateNewId();
        if (rId != null) {
            int newId = Integer.parseInt(rId.replace("RES-", "")) + 1;
            return String.format("RES-%03d", newId);
        } else {
            return "RES-001";
        }
    }

    private void loadAllId() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<String> room = roomBoImpl.searchRoomCode();
        ObservableList oList = FXCollections.observableArrayList(room);
        roomIdBox.setItems(oList);
    }

    private String generateStudentId() throws SQLException, ClassNotFoundException, IOException {
        String stId = studentBoImpl.generateNewStudentId();
        if (stId != null) {
            int newId = Integer.parseInt(stId.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newId);
        } else {
            return "S00-001";
        }
    }


    public void comfirmReservation(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        addStudent();
    }

    private void addStudent() throws SQLException, ClassNotFoundException, IOException {
        String sId = studentId.getText();
        String sName = studentName.getText();
        String sAddress = studentAddress.getText();
        String sContact = studentContact.getText();
        String dob = String.valueOf(DatePicker.getValue());
        String gd = gender;

        boolean s = studentBoImpl.saveStudent(new Student(sId, sName, sAddress, Integer.parseInt(sContact), dob, gd));
        selectRoom(sId);
    }

    private void selectRoom(String sId) throws SQLException, ClassNotFoundException, IOException {
        String resId = roomId.getText();
        String roomT = roomType.getText();
        String resDate = today();
        String rmId = roomId.getText();

        Reservation res = new Reservation(resId, roomT, sId, resDate, status);
        boolean r = reservationBo.saveReservation(res);
        if (r) {
            System.out.println("done");
        }
        manageRoom();
    }

    private void manageRoom() throws SQLException, ClassNotFoundException {
        String selectedRoom = roomType.getText();

        boolean d = roomBoImpl.updateQty(selectedRoom);
    }

    private String today() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dte = dtf.format(now);
        return dte;
    }

    public void genderAction(ActionEvent actionEvent) {
        if (maleBtn.isSelected()) {
            gender = "Male";
            femaleBtn.setSelected(false);
        }
        if (femaleBtn.isSelected()) {
            gender = "Female";
            maleBtn.setSelected(false);
        }
    }

    public void payAction(ActionEvent actionEvent) {
        if (payNow.isSelected()) {
            status = "Key Money is Done";
            payLater.setSelected(false);
        }
        if (payLater.isSelected()) {
            status = "Key Money is not Payed";
            payNow.setSelected(false);
        }
    }

    // Navigation
    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    // Navigation
    public void checkRooms(ActionEvent actionEvent) throws IOException {
        newResevationContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AllReservationForm.fxml"));
        newResevationContext.getChildren().add(parent);
    }

    // Navigation
    public void checkAvailableRooms(ActionEvent actionEvent) throws IOException {
        newResevationContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AVailableRoomForm.fxml"));
        newResevationContext.getChildren().add(parent);
    }
}