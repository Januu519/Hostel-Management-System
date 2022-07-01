package lk.ijse.HostelManagementSystem.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T,ID> extends SuperDao  {
    String exist() throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException, IOException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException, IOException;

    ArrayList<String> searchId() throws SQLException, ClassNotFoundException, IOException;

    T search(ID id) throws SQLException, ClassNotFoundException, IOException;

    boolean update(T dto) throws SQLException, ClassNotFoundException, IOException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException, IOException;

}
