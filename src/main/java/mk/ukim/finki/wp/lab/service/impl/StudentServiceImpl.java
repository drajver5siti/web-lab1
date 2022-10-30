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
        return this.students.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return this.students.findAllByNameOrSurname(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        return this.students.add(
                new Student(
                        username,
                        password,
                        name,
                        surname
                )
        );
    }

    @Override
    public boolean hasStudent(String username) {
        for(Student s : this.students.findAllStudents())
        {
            if(s.getUsername().equals(username)) {
                return  true;
            }
        }
        return false;
    }
}
