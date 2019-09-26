package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ViewPropertiesHandler {
    private static ResourceBundle viewProperties;

    public static final String PATH_MAIN = "PATH_MAIN";
    public static final String PATH_ERROR = "PATH_ERROR";
    public static final String PATH_INDEX = "PATH_INDEX";
    public static final String FRAGMENT_PATH_SIGN_IN = "FRAGMENT_PATH_SIGN_IN";
    public static final String FRAGMENT_PATH_PROCESS_REPORT = "FRAGMENT_PATH_PROCESS_REPORT";
    public static final String FRAGMENT_PATH_SEND_REPORT = "FRAGMENT_PATH_SEND_REPORT";
    public static final String FRAGMENT_PATH_SIGN_UP = "FRAGMENT_PATH_SIGN_UP";

    static {
        viewProperties = PropertyResourceBundle.getBundle("view");
    }

    public static String getViewPath(String propertyName) {
            if (propertyName == null) return null;
           return viewProperties.getString(propertyName);
    }
}
