package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create-student", urlPatterns = "/createStudent")
public class CreateStudentServlet extends HttpServlet {

//    private final SpringTemplateEngine templateEngine;
//    private final StudentService students;
//
//    public CreateStudentServlet(SpringTemplateEngine templateEngine, StudentService students) {
//        this.templateEngine = templateEngine;
//        this.students = students;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        if(req.getSession().getAttribute("courseId") == null) {
//            resp.sendRedirect("/listCourses");
//        }
//
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//
//        this.templateEngine.process("createStudent.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        if(req.getSession().getAttribute("courseId") == null) {
//            resp.sendRedirect("/listCourses");
//        }
//
//        if(
//                req.getParameter("username").isEmpty()
//                || req.getParameter("password").isEmpty()
//                || req.getParameter("name").isEmpty()
//                || req.getParameter("surname").isEmpty()
////                || this.students.hasStudent(req.getParameter("username"))
//        ) {
//            resp.sendRedirect("/createStudent");
//        }
//        else {
//            this.students.save(req.getParameter("username"),
//                req.getParameter("password"),
//                req.getParameter("name"),
//                req.getParameter("surname")
//            );
//
//            resp.sendRedirect("/AddStudent");
//        }
//    }
}
