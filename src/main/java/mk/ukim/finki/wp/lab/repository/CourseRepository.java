package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    public Course saveCourse(Course course) {
        this.courses.removeIf(c -> c.getCourseId().equals(course.getCourseId()));
        this.courses.add(course);

        return course;
    }

    public void deleteCourse(Course course) {
        this.courses.remove(course);
    }

    public List<Course> findAllCourses()
    {
        return this.courses;
    }

    public Optional<Course> findById(Long id) {
        return this.courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst();
    }

    public Optional<Course> findByName(String name) {
        return this.courses.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }

    public List<Student> findAllStudentsByCourse(Long courseId) {
        return courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .flatMap(c -> c.getStudents().stream())
                .collect(Collectors.toList());
    }

    public Course addStudentToCourse(Student student, Course course) {
        course.addStudent(student);
        return course;
    }
}
