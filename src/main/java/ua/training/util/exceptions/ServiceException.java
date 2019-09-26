package ua.training.util.exceptions;

public class ServiceException extends RuntimeException {
    private int errorCode;
    private String state;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
