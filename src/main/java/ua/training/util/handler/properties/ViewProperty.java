package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ViewProperty {
    private static ResourceBundle viewProperties;
    public static final String PATH_MAIN = "path.main";
    public static final String PATH_ERROR = "path.error";
    public static final String PATH_INDEX = "path.index";

    static {
        viewProperties = PropertyResourceBundle.getBundle("view");
    }

    public static String getViewPath(String propertyName) {
           return viewProperties.getString(propertyName);
    }
}
