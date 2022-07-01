package lk.ijse.HostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardFormController {
    public Label lblDate;
    public Label lblTime;
    public AnchorPane adminContext;
    public AnchorPane mainContext;





    public void btnNewReservationOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/NewReservationForm.fxml"));
        mainContext.getChildren().add(parent);


    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/ManageRoomForm.fxml"));
        mainContext.getChildren().add(parent);

    }

    public void btnManageStudentsOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/StudentsManageForm.fxml"));
        mainContext.getChildren().add(parent);

    }

    public void btnManageUsersOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/ManageUserForm.fxml"));
        mainContext.getChildren().add(parent);
    }
}
