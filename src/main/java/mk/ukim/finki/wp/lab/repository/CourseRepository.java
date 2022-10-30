package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>() {{
        add(new Course((long) 1, "Mrezna Bezbednost", "", new ArrayList<>()));
        add(new Course((long) 2, "Napredno Programiranje", "", new ArrayList<>()));
        add(new Course((long) 3, "Algoritmi i Podatocni sturkturi", "", new ArrayList<>()));
        add(new Course((long) 4, "Administracija na sistemi", "", new ArrayList<>()));
        add(new Course((long) 5, "Vestacka Inteligencija", "", new ArrayList<>()));
    }};

    public List<Course> findAllCourses()
    {
        return this.courses;
    }

    public Course findById(Long id)
    {
        return this.courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> findAllStudentsByCourse(Long courseId)
    {
        return courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .flatMap(c -> c.getStudents().stream())
                .collect(Collectors.toList());
    }

    public Course addStudentToCourse(Student student, Course course)
    {
        course.addStudent(student);
        return course;
    }
}
