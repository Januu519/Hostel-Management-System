package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBo extends SuperBo {
    ArrayList<Room> getAllRoom() throws SQLException, ClassNotFoundException;

    boolean deleteRoom(String code) throws SQLException, ClassNotFoundException, IOException;

    boolean saveRoom(Room dto) throws SQLException, ClassNotFoundException, IOException;

    boolean updateRoom(Room dto) throws SQLException, ClassNotFoundException, IOException;

    boolean existsRoom(String code) throws SQLException, ClassNotFoundException;

    Room searchRoom(String code) throws SQLException, ClassNotFoundException;

    ArrayList<String> searchRoomCode() throws SQLException, ClassNotFoundException;
}
