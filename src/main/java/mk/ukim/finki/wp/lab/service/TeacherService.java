package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherService {
    public List<Teacher> findAll();
}
