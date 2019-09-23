package ua.training.command;

import ua.training.persistance.beans.Report;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.function.Function;

public class CommandParamsExtractor {
    static <T> Optional<T>  extractParamsIntoBean(Function<HttpServletRequest, Optional<T>> function, HttpServletRequest request) {
        return function.apply(request);
    }
}
