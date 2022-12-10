package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TeacherService {

    List<Teacher> findAll();

    Teacher saveTeacher(String name, String surname);

    Optional<Teacher> findByNameAndSurname(String name, String surname);

    Optional<Teacher> findById(Long id);

    Optional<Teacher> editTeacher(Long id, String name, String surname);

    void deleteTeacher (Long id);
}
