package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository students;

    public StudentServiceImpl(StudentRepository students) {
        this.students = students;
    }

    @Override
    public List<Student> listAll() {
        return this.students.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return this.students.findAll();
//        return this.students.findAllByNameOrSurnameLike(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {

        return this.students.save(
                new Student(
                        username,
                        password,
                        name,
                        surname
                )
        );
    }
}
