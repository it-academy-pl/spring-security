package pl.itacademy.dao;

import pl.itacademy.connection.ConnectionManager;
import pl.itacademy.model.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDao implements StudentDao {

    @Override
    public List<Student> getAllStudents() throws SQLException, IOException {
        String firstName;
        String surname;
        String email;
        String password;

        ConnectionManager connectionManager = new ConnectionManager();
        List<Student> students = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                firstName = resultSet.getString(2);
                surname = resultSet.getString(3);
                email = resultSet.getString(4);
                password = resultSet.getString(5);
                students.add(new Student(firstName, surname, email, password));
            }
        }
        return students;

    }

    @Override
    public Student getStudentByEmail(String email) throws IOException, SQLException {
        String searchQuery = "select * from STUDENTS where email = ?";
        ConnectionManager connectionManager = new ConnectionManager();
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return new Student(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            } else {
                return null;
            }

        }
    }

    @Override
    public void addStudent(Student student) throws SQLException, IOException {
        String insertQuery = "insert into STUDENTS (name, surname, email, password) values (?, ?, ?, ?)";
        ConnectionManager connectionManager = new ConnectionManager();
        try(Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPassword());
            preparedStatement.execute();
            connection.commit();
        }
    }
}
