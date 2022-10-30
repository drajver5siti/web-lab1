package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courses;
    private final StudentRepository students;

    public CourseServiceImpl(
            CourseRepository courses,
            StudentRepository students
    )
    {
        this.courses = courses;
        this.students = students;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return this.courses.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        return this.courses.addStudentToCourse(
                this.students.findByUsername(username),
                this.courses.findById(courseId)
        );
    }

    @Override
    public List<Course> findAll() {
        return this.courses.findAllCourses();
    }
}
