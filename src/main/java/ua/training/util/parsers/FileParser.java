package ua.training.util.parsers;

import ua.training.util.exceptions.FileParsingException;

@FunctionalInterface
public interface FileParser<T> {
    T parseFile(String fileContent) throws FileParsingException;
}
