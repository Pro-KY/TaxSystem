package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class MessagePropertiesHandler {
    private static ResourceBundle messageProperties;
    public static final String SIGNIN_ERROR = "SIGNIN_ERROR";
    public static final String ERROR_PARSING = "PARSING_ERROR";
    public static final String REPORT_DETAILS_ERROR = "REPORT_DETAILS_ERROR";
    public static final String SERVICE_NULL_ENTITY_ERROR = "SERVICE_NULL_ENTITY_ERROR";
    public static final String SERVICE_TRANSACTION_ERROR = "SERVICE_TRANSACTION_ERROR";

    static {
        messageProperties = PropertyResourceBundle.getBundle("message");
    }

    public static String getMessage(String propertyName) {
           return messageProperties.getString(propertyName);
    }
}
