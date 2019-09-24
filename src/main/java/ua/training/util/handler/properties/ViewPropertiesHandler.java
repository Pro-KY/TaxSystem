package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ViewPropertiesHandler {
    private static ResourceBundle viewProperties;

    public static final String PATH_MAIN = "PATH_MAIN";
    public static final String PATH_ERROR = "PATH_ERROR";
    public static final String PATH_INDEX = "PATH_INDEX";
    public static final String PATH_LOGIN = "PATH_LOGIN";
    public static final String PATH_INSPECTOR_PROCESS_REPORT = "PATH_INSPECTOR_PROCESS_REPORT";
    public static final String PATH_USER_SEND_REPORT = "PATH_USER_SEND_REPORT";

    static {
        viewProperties = PropertyResourceBundle.getBundle("view");
    }

    public static String getViewPath(String propertyName) {
            if (propertyName == null) return null;
           return viewProperties.getString(propertyName);
    }
}
