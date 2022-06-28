package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageFormController {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public AnchorPane LogInContext;


    public void btnCancelOnAction(ActionEvent actionEvent) {



    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) LogInContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
