package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.event.ActionEvent;
import org.hibernate.sql.Update;

public class ManageUserFormController {
    public JFXTextField txtUserId;
    public JFXTextField txtUsersName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public JFXPasswordField pdwConfirmPassword;

    public void btnUpdateAccountOnAction(ActionEvent actionEvent) {
       /* String p1 = pwdPassword.getText();
        String p2 = pdwConfirmPassword.getText();

        if (p2.equals(p1)){
            Update();
        }else{
            // Show alert about passwords are not match
        }
        public void Update(){
            String UId = UserId.getText();
            String Name = UserName.getText();
            String uAddress = UserAddress.getText();
            int uContact = Integer.parseInt(userContact.getText());
            String usName = uName.getText();
            String newPassword = comfirmPassword.getText();
        */
    }

    public void btnDeleteAccountOnAction(ActionEvent actionEvent) {
           /* String uId = UserId.getText();*/
        }
    }

