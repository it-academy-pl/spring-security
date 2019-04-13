package pl.itacademy.servlet;

import pl.itacademy.dao.StudentJdbcDao;
import pl.itacademy.model.Student;
import pl.itacademy.service.StudentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/searchStudent")
public class SearchStudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("searchStudent");
        Student foundStudent = studentService.getByEmail(name);
        out.println("<html><body><h1>Student found</h1>");
        out.println("<p>" + foundStudent.getName() + " " + foundStudent.getSurname() + " " +
                foundStudent.getEmail() + "</p>");
        out.println("</body></html>");
        out.close();
    }


}
