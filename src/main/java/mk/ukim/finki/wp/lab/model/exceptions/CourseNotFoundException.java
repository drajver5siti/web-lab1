package mk.ukim.finki.wp.lab.model.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(Long id) {
        super(String.format("Course with id %d was not found", id));
    }
}
