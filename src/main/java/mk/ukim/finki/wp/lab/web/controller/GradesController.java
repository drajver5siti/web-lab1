package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/grades")
public class GradesController {
    private GradeService grades;

    public GradesController(GradeService grades) {
        this.grades = grades;
    }

    @GetMapping
    public String getGradesPage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Grade> grades = this.grades.findAll();

        model.addAttribute("grades", grades);

        return "grades/listGrades";
    }
}
