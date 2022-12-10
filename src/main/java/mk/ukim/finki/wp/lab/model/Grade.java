package mk.ukim.finki.wp.lab.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character grade;

    @OneToOne
    private Student student;

    @OneToOne
    private Course course;

    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime timestamp;

    protected Grade() {
    }

    public Long getId() {
        return id;
    }

    public Character getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
