package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teachers;

    public TeacherController(
            TeacherService teachers
    ) {
        this.teachers = teachers;
    }

    @GetMapping
    public String getTeachersPage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Teacher> teachers = this.teachers.findAll();

        model.addAttribute("teachers", teachers);
        return "teachers/listTeachers";
    }

    @GetMapping("/edit/{id}")
    public String getEditCoursePage(
            @PathVariable Long id,
            Model model
    ) {
        if(this.teachers.findById(id).isPresent()) {
            Teacher teacher = this.teachers.findById(id).get();
            model.addAttribute("teacher", teacher);

            return "teachers/addTeacher";
        }

        return "redirect:/teachers?error=TeacherNotFound";
    }


    @GetMapping("/add")
    public String addTeacherPage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "teachers/addTeacher";
    }

    @PostMapping("/add")
    public String saveTeacher(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String surname
    ) {
        Optional<Teacher> exists = this.teachers.findByNameAndSurname(name, surname);
        if(exists.isPresent() && !exists.get().getId().equals(id)) {
            return "redirect:/teachers/add?error=TeacherAlreadyExists";
        }

        if(id == null) {
            this.teachers.saveTeacher(name, surname);
        } else {
            this.teachers.editTeacher(id, name, surname);
        }

        return "redirect:/teachers";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeacher(
            @PathVariable Long id
    ) {
        this.teachers.deleteTeacher(id);
        return "redirect:/teachers";
    }

}
