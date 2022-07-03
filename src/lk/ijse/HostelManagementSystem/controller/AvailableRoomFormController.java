package lk.ijse.HostelManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AvailableRoomFormController implements Initializable {
    public AnchorPane availableRoomsContext;
    public TableView<Room> roomTable;
    public TableColumn roomId;
    public TableColumn roomType;
    public TableColumn keyMoney;
    public TableColumn qty;
    public ImageView homeBtn;
    public ImageView backBtn;
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);


    public void setBackBtn(MouseEvent mouseEvent) throws IOException {
        availableRoomsContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AllReservationsForm.fxml"));
        availableRoomsContext.getChildren().add(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        keyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        try {
            loadEmptyRooms();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEmptyRooms() throws Exception {
        List<Room> roomList = roomBoImpl.getAllRoom();
        ObservableList<Room> list = FXCollections.observableArrayList();
        list.addAll(roomList);
        roomTable.setItems(list);
    }

    public void backbtn(MouseEvent mouseEvent) throws IOException {

        availableRoomsContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/NewReservationForm.fxml"));
        availableRoomsContext.getChildren().add(parent);
    }

    public void homebtn(MouseEvent mouseEvent) throws IOException {
        availableRoomsContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../views/DashBoardForm.fxml"));
        availableRoomsContext.getChildren().add(parent);
    }
}
