package ua.training.util.exceptions;

public class ExceptionThrower {
    @SuppressWarnings("unchecked")
    public static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
        throw (T) t;
    }
}
