package ua.training.util;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;

//    static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
//        return i -> {
//            try {
//                throwingConsumer.accept(i);
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        };
//    }
}
