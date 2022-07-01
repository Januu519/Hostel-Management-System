package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBo {
    ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException;

    boolean deleteUser(String code) throws SQLException, ClassNotFoundException, IOException;

    boolean saveUser(User dto) throws SQLException, ClassNotFoundException, IOException;

    boolean updateUser(User dto) throws SQLException, ClassNotFoundException, IOException;

    boolean existsUser(String code) throws SQLException, ClassNotFoundException;

    Room searchUser(String code) throws SQLException, ClassNotFoundException;

    String generateNewUserId() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchUserCode() throws SQLException, ClassNotFoundException;

}
