package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtRoomId;
    public JFXTextField txtKeymoney;
    public DatePicker datepicker;
    public RadioButton maleBtn;
    public RadioButton femaleBtn;
    public Label lblGender;
    public RadioButton payNow;
    public RadioButton payLater;
    public AnchorPane newResevationContext;
    public ImageView homeBtn;
    /* private StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
     private RoomBo roomBo = (RoomBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);*/
    String gender;
    String status;

    public void btnConfirmOnAction(ActionEvent actionEvent) {

    }

    public void btnAllOnAction(ActionEvent actionEvent) throws IOException {
        newResevationContext .getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/AllReservationsForm.fxml"));
        newResevationContext.getChildren().add(parent);

    }

    public void btnCheckAvailabilityOnAction(ActionEvent actionEvent) throws IOException {
        newResevationContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/AvailableRoomForm.fxml"));
        newResevationContext.getChildren().add(parent);
    }

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
}
