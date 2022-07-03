package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.impl.UserBoImpl;
import lk.ijse.HostelManagementSystem.entity.User;
import org.hibernate.sql.Update;

import java.io.IOException;
import java.sql.SQLException;

public class ManageUserFormController {

    public ImageView homeBtn;
    public Button updateb;
    public Button delete;
    public Button add;
    public Button clear;
    public JFXTextField userId;
    public JFXTextField userName;
    public JFXTextField userAddress;
    public JFXTextField userContact;
    public JFXTextField uName;
    public JFXPasswordField uPassword;
    public JFXPasswordField comfirmPassword;
    UserBoImpl userBoImpl = (UserBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);


    public void updateUser(ActionEvent actionEvent) throws Exception{
        String p1 = uPassword.getText();
        String p2 = comfirmPassword.getText();

        if (p2.equals(p1)){
            String s = "update";
            addAndUpdate(s);
        }else{
            new Alert(Alert.AlertType.WARNING,"Passwords are Doesn't Match !..").showAndWait();
        }
    }

    public void deleteUser(ActionEvent actionEvent) throws Exception {
        String uId = userId.getText();
        boolean deleted = userBoImpl.deleteUser(uId);

    }

    public void addRoom(ActionEvent actionEvent) throws Exception {
        String s = "add";
        addAndUpdate(s);
    }

    private void addAndUpdate(String s) throws Exception {


        String uId = userId.getText();
        String Name = userName.getText();
        String uAddress = userAddress.getText();
        int uContact = Integer.parseInt(userContact.getText());
        String usName = uName.getText();
        String newPassword = comfirmPassword.getText();

        if(s.equals("add")){
            boolean b = userBoImpl.saveUser(new User(uId,Name,uAddress,uContact,usName,newPassword));
        }
        else if (s.equals("update")){
            boolean b = userBoImpl.updateUser(new User(uId,Name,uAddress,uContact,usName,newPassword));
        }
    }

    public void clearData(ActionEvent actionEvent) {
        userId.clear();
        uName.clear();
        userAddress.clear();
        userContact.clear();
        userName.clear();
        uPassword.clear();
        comfirmPassword.clear();

    }
}

