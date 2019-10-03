package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class MessagePropertiesHandler {
    private static ResourceBundle messageProperties;
    public static final String LOGIN_ERROR = "SIGNIN_ERROR";
    public static final String ERROR_PARSING = "PARSING_ERROR";
    public static final String REPORT_DETAILS_ERROR_MSG = "REPORT_DETAILS_ERROR_MSG";
    public static final String REPORT_ERROR_MSG = "REPORT_ERROR_MSG";

    static {
        messageProperties = PropertyResourceBundle.getBundle("message");
    }

    public static String getMessage(String propertyName) {
           return messageProperties.getString(propertyName);
    }
}
