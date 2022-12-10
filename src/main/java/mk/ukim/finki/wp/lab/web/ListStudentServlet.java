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

@WebServlet(name = "list-student", urlPatterns = "/AddStudent")
public class ListStudentServlet extends HttpServlet {

//    private  final SpringTemplateEngine templateEngine;
//    private  final StudentService students;
//
//    public ListStudentServlet(SpringTemplateEngine templateEngine, StudentService students) {
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
//        context.setVariable("students", this.students.listAll());
//        context.setVariable("courseId", req.getSession().getAttribute("courseId"));
//
//        this.templateEngine.process("listStudents.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariable("students", this.students.listAll());
//        context.setVariable("courseId", req.getParameter("courseId"));
//        req.getSession().setAttribute("courseId", req.getParameter("courseId"));
//
//        if(req.getSession().getAttribute("courseId") == null) {
//            resp.sendRedirect("/listCourses");
//        }
//
//        this.templateEngine.process("listStudents.html", context, resp.getWriter());
//    }
}
