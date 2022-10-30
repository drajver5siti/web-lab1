package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<Student>() {{
        add(new Student("john.doe", "test123", "John", "Doe"));
        add(new Student("jim.mich", "test123", "Jim", "Mich"));
        add(new Student("sarah.and", "test123", "Sarah", "Anderson"));
        add(new Student("aileen.fields", "test123", "Aileen", "Fields"));
        add(new Student("chadwick.matt", "test123", "Chadwick", "Matt"));
    }};

    public List<Student> findAllStudents()
    {
        return this.students;
    }

    public List<Student> findAllByNameOrSurname(String text)
    {
        return this.students.stream()
                .filter(st -> st.getName().contains(text) || st.getSurname().contains(text))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Student findByUsername(String username)
    {
        return  this.students.stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Student add(Student student)
    {
        this.students.add(student);
        return student;
    }

}
