package mk.ukim.finki.wp.lab.model;

import java.util.List;
import java.util.Objects;

public class Course {
    private Long courseId;
    private String name;
    private String description;
    private Teacher teacher;
    private List<Student> students;

    public Course(
            String name,
            String description,
            Teacher teacher
    ) {
        this.courseId = (long) (Math.random() * 10000);
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() { return teacher; }

    public void addStudent(Student student) {
        if(!this.students.contains(student)) {
            this.students.add(student);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}
