package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.HostelManagementSystem.entity.Room;

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
    public ImageView homeBtn;
    public JFXTextField dobField;
    public JFXTextField genderField;
    private StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtStudentId.clear();
        txtName.clear();
       txtAddress.clear();
        txtContact.clear();
        dobField.clear();
        genderField.clear();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String sId = txtStudentId.getText();
      /*  String sName = txtName.getText();
        String sAddress= txtAddress.getText();
        int qt = Integer.parseInt(txtQty.getText());

        Room room = new Room(roomTypeId,rType,kMoney,qt);

        boolean b = roomBoImpl.updateRoom(room);
*/
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
