package ua.training.util.parsers;

import ua.training.util.exceptions.FileParsingException;

/**
 * The interface for parsing different kind of files, like xml, json etc.
 */
@FunctionalInterface
public interface FileParser<T> {

    /**
     * The method for implementation file parsing logic.
     * @param fileContent is a file content that will be parsed
     * @return is a POJO that represents parsed file content
     */
    T parseFile(String fileContent) throws FileParsingException;
}
