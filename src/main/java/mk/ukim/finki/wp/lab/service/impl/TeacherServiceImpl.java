package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.exceptions.TeacherNotFoundException;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public Teacher saveTeacher(String name, String surname) { return this.teachers.save(new Teacher(name, surname)); }

    public Optional<Teacher> findByNameAndSurname(String name, String surname) {
        return this.teachers.findByNameAndSurname(name, surname);
    }

    public Optional<Teacher> findById(Long id) {
        return this.teachers.findById(id);
    }

    public Optional<Teacher> editTeacher(Long id, String name, String surname) {
        Teacher t = this.teachers
                .findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));

        t.setName(name);
        t.setSurname(surname);

        return Optional.of(this.teachers.save(t));

    }

    public void deleteTeacher(Long id) {
        Teacher t = this.teachers
                .findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));

        this.teachers.delete(t);
    }

}
