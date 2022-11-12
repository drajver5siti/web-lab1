package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.wp.lab.model.exceptions.TeacherNotFoundException;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courses;
    private final StudentRepository students;
    private final TeacherRepository teachers;

    public CourseServiceImpl(
            CourseRepository courses,
            StudentRepository students,
            TeacherRepository teachers
    )
    {
        this.courses = courses;
        this.students = students;
        this.teachers = teachers;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return this.courses.findById(id);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return this.courses.findByName(name);
    }

    @Override
    public Course saveCourse(String name, String description, Long teacherId) {

        Teacher teacher = this.teachers
                .findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(teacherId));

        return this.courses.saveCourse(new Course(name, description, teacher));
    }

    @Override
    public Course editCourse(Long courseId, String name, String description, Long teacherId) {

        Course course = this.courses
                .findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));

        Teacher teacher = this.teachers
                .findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(teacherId));


        course.setName(name);
        course.setDescription(description);
        course.setTeacher(teacher);

        return this.courses.saveCourse(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = this.courses
                .findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));

        this.courses.deleteCourse(course);
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return this.courses.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {

        Course course = this.courses
                .findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));

        return this.courses.addStudentToCourse(
                this.students.findByUsername(username),
                course
        );
    }

    @Override
    public List<Course> findAll() {
        return this.courses.findAllCourses();
    }
}
