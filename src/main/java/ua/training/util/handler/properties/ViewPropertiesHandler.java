package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ViewPropertiesHandler {
    private static ResourceBundle viewProperties;

    public static final String PATH_MAIN = "path.main";
    public static final String PATH_ERROR = "path.error";
    public static final String PATH_INDEX = "path.index";
    public static final String PATH_INSPECTOR_PROCESS_REPORT = "path.inspector.process_report";
    public static final String PATH_USER_SEND_REPORT = "path.user.send_report";

    static {
        viewProperties = PropertyResourceBundle.getBundle("view");
    }

    public static String getViewPath(String propertyName) {
            if (propertyName == null) return null;
           return viewProperties.getString(propertyName);
    }
}
