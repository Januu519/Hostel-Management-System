package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class StudentsManageFormController {
    public JFXTextField txtAddress;
    public JFXTextField txtName;
    public JFXTextField txtStudentId;
    public JFXTextField txtContact;
    public JFXComboBox studentIdBox;
    public Label lblGender;
    public RadioButton maleBtn;
    public RadioButton femaleBtn;
    public AnchorPane manageStudentsContext;

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
