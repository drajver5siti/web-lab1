package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "student-enrollment", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummaryServlet extends HttpServlet {

    private final CourseService courses;
    private final SpringTemplateEngine templateEngine;

    public StudentEnrollmentSummaryServlet(CourseService courses, SpringTemplateEngine templateEngine) {
        this.courses = courses;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("courseId") == null) {
            resp.sendRedirect("/listCourses");
        }

        String studentUsername = req.getParameter("student");
        long courseId = Long.parseLong((String) req.getSession().getAttribute("courseId"));
        Course course = this.courses.addStudentInCourse(studentUsername, courseId);

        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("course", course);

        this.templateEngine.process("/studentsInCourse.html", context, resp.getWriter());
    }
}
