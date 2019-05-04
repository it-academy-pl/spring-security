package pl.itacademy.servlet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.itacademy.model.Student;
import pl.itacademy.service.StudentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addStudent")
public class AddStudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        studentService.addStudent(new Student(name, surname, email, encoder.encode(password)));
        out.println("<html><body><p>Student had been added successfully</></br>");
        out.println("name: " + name + " surname " + surname + " index no " + email);
        out.println("</body></html>");
        out.close();
    }
}
