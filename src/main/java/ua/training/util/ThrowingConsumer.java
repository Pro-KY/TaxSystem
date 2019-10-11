package ua.training.util;

/**
 * The interface that defines {@link java.util.function.Consumer} that throws Exception
 */
@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
    /**
     * The method for implementation file parsing logic.
     * @param object is a POJO that represents parsed file content
     */
    void accept(T object) throws E;
}
