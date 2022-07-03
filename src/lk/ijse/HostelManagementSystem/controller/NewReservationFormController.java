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
            } catch (Exception   e) {
                e.printStackTrace();
            }
        });

    }

    private String generateRoomId() throws Exception {
        String rId = null;
        try {
            rId = reservationBo.generateNewId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (rId != null) {
            int newId = Integer.parseInt(rId.replace("RES-", "")) + 1;
            return String.format("RES-%03d", newId);
        } else {
            return "RES-001";
        }
    }

    private void loadAllId() throws Exception {
        ArrayList<String> room = null;
        try {
            room = roomBoImpl.searchRoomCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObservableList oList = FXCollections.observableArrayList(room);
        roomIdBox.setItems(oList);
    }

    private String generateStudentId() throws Exception {
        String stId = null;
        try {
            stId = studentBoImpl.generateNewStudentId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (stId != null) {
            int newId = Integer.parseInt(stId.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newId);
        } else {
            return "S00-001";
        }
    }


    public void comfirmReservation(ActionEvent actionEvent) throws Exception{
        addStudent();
    }

    private void addStudent() throws Exception{
        String sId = studentId.getText();
        String sName = studentName.getText();
        String sAddress = studentAddress.getText();
        String sContact = studentContact.getText();
        String dob = String.valueOf(DatePicker.getValue());
        String gd = gender;

        try {
            boolean s = studentBoImpl.saveStudent(new Student(sId, sName, sAddress, Integer.parseInt(sContact), dob, gd));
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectRoom(sId);
    }

    private void selectRoom(String sId) throws Exception{
        String resId = roomId.getText();
        String roomT = roomType.getText();
        String resDate = today();
        String rmId = roomId.getText();

        Reservation res = new Reservation(resId, roomT, sId, resDate, status);
        boolean r = false;
        try {
            r = reservationBo.saveReservation(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (r) {
            System.out.println("done");
        }
        manageRoom();
    }

    private void manageRoom() throws Exception {
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
    public void goHome(MouseEvent mouseEvent) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../views/dashboardForm.fxml"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(parent));
        stage1.show();

        Stage stage2 = (Stage) homeBtn.getScene().getWindow();
        stage2.close();
    }

    // Navigation
    public void checkRooms(ActionEvent actionEvent) throws Exception{
        newResevationContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/AllReservationsForm.fxml"));
        newResevationContext.getChildren().add(parent);
    }

    // Navigation
    public void checkAvailableRooms(ActionEvent actionEvent) throws Exception {
        newResevationContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/AvailableRoomForm.fxml"));
        newResevationContext.getChildren().add(parent);
    }

    public void getDate(ActionEvent actionEvent) {
    }
}