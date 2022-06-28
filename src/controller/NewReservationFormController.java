package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

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

    public void btnConfirmOnAction(ActionEvent actionEvent) {
    }

    public void btnAllOnAction(ActionEvent actionEvent) {
    }

    public void btnCheckAvailabilityOnAction(ActionEvent actionEvent) {
    }

    public void getDate(ActionEvent actionEvent) {
    }
}
