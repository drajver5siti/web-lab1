package mk.ukim.finki.wp.lab.model.exceptions;

public class StudentNotFoundException  extends RuntimeException{
    public StudentNotFoundException(String username) {
        super(String.format("Student with username %s was not found", username));

    }
}
