package ua.training.util;

import java.util.function.Predicate;

// will validate all params from the client
public class ParamsValidator {
    <T> boolean isParametersValid(Predicate<T> predicate, T value) {
        return predicate.test(value);
    }
}
