package hu.regina.domain.exeptions;

public class InvalidIdExeption extends RuntimeException {

    public InvalidIdExeption(String message) {
        super(message);
    }
}
