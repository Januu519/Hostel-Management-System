package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.StudentDao;
import lk.ijse.HostelManagementSystem.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {

    @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public ArrayList<String> searchId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
