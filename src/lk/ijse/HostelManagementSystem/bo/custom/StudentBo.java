package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.dto.StudentDto;
import lk.ijse.HostelManagementSystem.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBo extends SuperBo {
    List<Student> getAllStudent() throws Exception;

    boolean deleteStudent(String code) throws Exception;

    boolean saveStudent(Student dto) throws Exception;

    boolean updateStudent(Student dto) throws Exception;

    boolean existsStudent(String code) throws Exception;

    Student searchStudent(String code) throws Exception;

    String generateNewStudentId() throws Exception;

    ArrayList<String> searchStudentCode() throws Exception;
}
