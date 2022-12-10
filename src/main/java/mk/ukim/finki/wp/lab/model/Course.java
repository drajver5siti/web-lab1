package mk.ukim.finki.wp.lab.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToOne
    private Teacher teacher;

    @ManyToMany
    private List<Student> students;

    @Enumerated(EnumType.STRING)
    private Type type;

    protected Course() {}

    public Course(
            String name,
            String description,
            Teacher teacher
    ) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
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
        return Objects.equals(id, course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
