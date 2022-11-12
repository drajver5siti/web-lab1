package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepository {
    private List<Teacher> teachers = new ArrayList<>() {{
        add(new Teacher("Ana", "Todorovska"));
        add(new Teacher("Vojdan", "Kjorvezinski"));
        add(new Teacher("Anastas", "Mishev"));
        add(new Teacher("Sonja", "Gievska"));
        add(new Teacher("Sonja", "Filipovska"));
    }};

    public List<Teacher> findAll() {
        return this.teachers;
    }

    public Optional<Teacher> findById(Long teacherId) {
        return this.teachers.stream()
                .filter(t -> t.getId().equals(teacherId))
                .findFirst();
    }

}
