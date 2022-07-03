package lk.ijse.HostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HostelManagementSystem.bo.BOFactory;
import lk.ijse.HostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.HostelManagementSystem.bo.custom.impl.RoomBoImpl;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.io.IOException;
import java.sql.SQLException;

public class ManageRoomFormController {
    public JFXTextField txtQty;
    public JFXComboBox roomIdBox;
    public JFXTextField txtRoomId;
    public JFXTextField txtKeymoney;
    public AnchorPane manageRoomsContext;
    public JFXTextField roomType;
    public ImageView homeBtn;
    RoomBoImpl roomBoImpl = (RoomBoImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void btnClearFieldsOnActiion(ActionEvent actionEvent) {
        txtRoomId.clear();
        roomType.clear();
        txtKeymoney.clear();
        txtQty.clear();

    }

    public void btnAddRoomOnAction(ActionEvent actionEvent) throws Exception {
        String roomTypeId = txtRoomId.getText();
        String rType = roomType.getText();
        String kMoney = txtKeymoney.getText();
        int qt = Integer.parseInt(txtQty.getText());

        Room room = new Room(roomTypeId,rType,kMoney,qt);

        boolean b = roomBoImpl.saveRoom(room);

    }

    public void btnUpdateRoomOnAction(ActionEvent actionEvent) throws Exception {
        String roomTypeId = txtRoomId.getText();
        String rType = roomType.getText();
        String kMoney = txtKeymoney.getText();
        int qt = Integer.parseInt(txtQty.getText());

        Room room = new Room(roomTypeId,rType,kMoney,qt);

        boolean b = roomBoImpl.updateRoom(room);


    }

    public void btnDeleteOnaction(ActionEvent actionEvent) throws Exception {
        String roomTypeId = txtRoomId.getText();

        boolean b = roomBoImpl.deleteRoom(roomTypeId);



    }

    public void addAndUpdate (String methName){
        String roomTypeId = txtRoomId.getText();
        String rType = roomType.getText();
        String kMoney = txtKeymoney.getText();
        int qt = Integer.parseInt(txtQty.getText());

        if (methName.equals("add")){
            // set Dependency injection with roomBo and continue adding room
        }else if(methName.equals("update")){
            // set Dependency injection with roomBo and continue update room
        }

    }
}
