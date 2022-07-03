package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomBo extends SuperBo {
    List<Room> getAllRoom() throws Exception;

    boolean deleteRoom(String code) throws Exception;

    boolean saveRoom(Room dto) throws Exception;

    boolean updateRoom(Room dto) throws Exception;

    boolean existsRoom(String code) throws Exception;

    Room searchRoom(String code) throws Exception;

    ArrayList<String> searchRoomCode() throws Exception;



}
