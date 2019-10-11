package ua.training.util.exceptions;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Object entityId) {
        super(message + entityId);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
