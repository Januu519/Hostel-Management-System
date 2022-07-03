package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.entity.Room;
import lk.ijse.HostelManagementSystem.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserBO extends SuperBo {
    List<User> getAllUser() throws Exception;

    boolean deleteUser(String code) throws Exception;

    boolean saveUser(User dto) throws Exception;

    boolean updateUser(User dto) throws Exception;

    boolean existsUser(String code) throws Exception;

    Room searchUser(String code) throws Exception;

    String generateNewUserId() throws Exception;

    ArrayList<String> searchUserCode() throws Exception;

}
