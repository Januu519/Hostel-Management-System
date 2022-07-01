package lk.ijse.HostelManagementSystem.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AvailableRoomFormController {
    public AnchorPane availableRoomsContext;
    public TableView roomTable;
    public TableColumn roomId;
    public TableColumn roomType;
    public TableColumn keyMoney;
    public TableColumn qty;
    public ImageView homeBtn;


    public ImageView backBtn;


    public void setBackBtn(MouseEvent mouseEvent) throws IOException {
        availableRoomsContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AllReservationsForm.fxml"));
        availableRoomsContext.getChildren().add(parent);
    }
}
