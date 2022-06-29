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



   /* public void initialize() throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/NewReservationForm.fxml"));
        mainContext.getChildren().add(parent);*/


    public void btnNewReservationOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/NewReservationForm.fxml"));
        mainContext.getChildren().add(parent);

    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageRoomForm.fxml"));
        mainContext.getChildren().add(parent);

    }

    public void btnManageStudentsOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageStudentForm.fxml"));
        mainContext.getChildren().add(parent);

    }
}