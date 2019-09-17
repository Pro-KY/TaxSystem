package ua.training.util.exceptions;

public class BeanMappingException extends Exception {
    public BeanMappingException(String message) {
        super(message);
    }

    public BeanMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
