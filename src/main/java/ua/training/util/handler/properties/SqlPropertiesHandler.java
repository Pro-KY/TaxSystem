package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SqlPropertiesHandler {
    private static ResourceBundle sqlProperties;
    public static final String LOGIN_AND_PASSWORD = "LOGIN_AND_PASSWORD";
    public static final String GET_TAX_TYPE_BY_NAME = "TAX_TYPE_BY_NAME";
    public static final String ALL_TAX_TYPES = "ALL_TAX_TYPES";
    public static final String REPORT_STATE_BY_NANE = "REPORT_STATE_BY_NANE";
    public static final String SAVE_REPORT = "SAVE_REPORT";
    public static final String SAVE_SEND_REPORT_EVENT = "SAVE_SEND_REPORT_EVENT";
    public static final String PAGINATION = "PAGINATION";


    static {
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static String getSqlQuery(String propertyName) {
        return sqlProperties.getString(propertyName);
    }
}
