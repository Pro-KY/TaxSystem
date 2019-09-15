package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class MessageProperty {
    private static ResourceBundle messageProperties;
    public static final String LOGIN_ERROR = "login.error";

    static {
        messageProperties = PropertyResourceBundle.getBundle("message");
    }

    public static String getMessage(String propertyName) {
           return messageProperties.getString(propertyName);
    }
}
