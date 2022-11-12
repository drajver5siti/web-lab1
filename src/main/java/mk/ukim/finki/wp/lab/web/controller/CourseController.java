package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/courses")
public class CourseController {


    private final CourseService courses;
    private final TeacherService teachers;

    public CourseController(CourseService courses, TeacherService teachers) {
        this.courses = courses;
        this.teachers = teachers;
    }

    @GetMapping
    public String getCoursesPage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Course> courses = this.courses.findAll()
                .stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        model.addAttribute("courses", courses);
        return "listCourses";
    }

    @GetMapping("/add")
    public String getAddCoursePage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Teacher> teachers = this.teachers.findAll();
        model.addAttribute("teachers", teachers);
        return "add-course";
    }

    @GetMapping("/edit/{id}")
    public String getEditCoursePage(
            @PathVariable Long id,
            Model model
    ) {
        if(this.courses.findById(id).isPresent()) {
            Course course = this.courses.findById(id).get();
            List<Teacher> teachers = this.teachers.findAll();

            model.addAttribute("course", course);
            model.addAttribute("teachers", teachers);

            return "add-course";
        }

        return "redirect:/courses?error=CourseNotFound";
    }


    @PostMapping("/add")
    public String saveCourse(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Long teacherId
    ) {
        Optional<Course> exists = this.courses.findByName(name);
        if(exists.isPresent() && !exists.get().getCourseId().equals(id)) {
            return "redirect:/courses/add?error=CourseAlreadyExists";
        }
        if(id == null) {
            this.courses.saveCourse(name, description, teacherId);
        } else {
            this.courses.editCourse(id, name, description, teacherId);
        }

        return "redirect:/courses";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(
            @PathVariable Long id
    ) {
        this.courses.deleteCourse(id);
        return "redirect:/courses";
    }
}
