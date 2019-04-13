package pl.itacademy.dao;

import pl.itacademy.model.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInMemoryDao implements StudentDao {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Mikolaj", "Kopernik", "kopernik@torun.pl", "qwerty"));
        students.add(new Student("Krzysztof", "Jarzyna", "jarzyna@ze.szczecina.pl", "grucha"));
        students.add(new Student("Robert", "Lewandowski", "robert@bayern.com", "5goli"));
    }

    @Override
    public List<Student> getAllStudents() throws SQLException, IOException {
        return students;
    }

    @Override
    public Student getStudentByEmail(String email) {
        return students.stream().filter(student -> student.getEmail().equals(email)).findAny().get();
    }

    @Override
    public void addStudent(Student student) {
        students.add(new Student(student.getName(), student.getSurname(), student.getEmail(), student.getPassword()));
    }
}
