package pl.itacademy.dao;

import pl.itacademy.model.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents() throws SQLException, IOException;

    Student getStudentByEmail(String email) throws IOException, SQLException;
    void addStudent(Student student) throws SQLException, IOException;
}
