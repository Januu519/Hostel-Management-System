package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;

import java.io.IOException;

public class NewReservationFormController {

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
    /* private StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
     private RoomBo roomBo = (RoomBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);*/
    String gender;
    String status;




    public void getDate(ActionEvent actionEvent) {
    }

    public void genderAction(ActionEvent actionEvent) {
        if (maleBtn.isSelected()){
           gender = "Male";
            femaleBtn.setSelected(false);
        }
        if (femaleBtn.isSelected()){
            gender = "Female";
            maleBtn.setSelected(false);
        }
    }

    public void payAction(ActionEvent actionEvent) {
        if (payNow.isSelected()){
            status = "Key Money is Done";
            payLater.setSelected(false);
        }
        if (payLater.isSelected()){
            status = "Key Money is not Payed";
            payNow.setSelected(false);
        }
    }

    public void checkRooms(ActionEvent actionEvent) {
    }

    public void checkAvailableRooms(ActionEvent actionEvent) throws IOException {
        newResevationContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/AvailableRoomForm.fxml"));
        newResevationContext.getChildren().add(parent);

    }

    public void comfirmReservation(ActionEvent actionEvent) {
    }
}
