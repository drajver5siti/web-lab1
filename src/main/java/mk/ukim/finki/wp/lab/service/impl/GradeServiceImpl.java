package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.repository.GradesRepository;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradesRepository grades;

    public GradeServiceImpl(GradesRepository grades) {
        this.grades = grades;
    }

    @Override
    public List<Grade> findAll() {
        return this.grades.findAll();
    }
}
