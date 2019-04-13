package pl.itacademy.servlet;

import pl.itacademy.model.Student;
import pl.itacademy.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/allStudents")
public class AllStudentsServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        List<Student> students = null;

        students = studentService.getAllStudents();
        request.setAttribute("students", students);
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/allStudents.jsp");
        dispatch.forward(request, response);

    }

}
