package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBo extends SuperBo {
    ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String code) throws SQLException, ClassNotFoundException;

    boolean saveStudent(Student dto) throws SQLException, ClassNotFoundException, IOException;

    boolean updateStudent(Student dto) throws SQLException, ClassNotFoundException, IOException;

    boolean existsStudent(String code) throws SQLException, ClassNotFoundException;

    Student searchStudent(String code) throws SQLException, ClassNotFoundException, IOException;

    String generateNewStudentId() throws SQLException, ClassNotFoundException, IOException;

    ArrayList<String> searchStudentCode() throws SQLException, ClassNotFoundException, IOException;
}
