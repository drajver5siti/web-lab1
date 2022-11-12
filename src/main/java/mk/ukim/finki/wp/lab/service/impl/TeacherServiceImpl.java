package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teachers;

    public TeacherServiceImpl(TeacherRepository teachers) {
        this.teachers = teachers;
    }

    @Override
    public List<Teacher> findAll() {
        return this.teachers.findAll();
    }
}
