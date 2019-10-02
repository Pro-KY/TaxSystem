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
    public static final String SAVE_REPORT_APPROVAL = "SAVE_REPORT_APPROVAL";
    public static final String SAVE_USER = "SAVE_USER";

    public static final String REPORT_APPROVAL_PAGINATION = "REPORT_APPROVAL_PAGINATION";
    public static final String REPORT_APPROVAL_COUNT = "REPORT_APPROVAL_COUNT";
    public static final String REPORT_APPROVAL_BY_ID = "REPORT_APPROVAL_BY_ID";


    static {
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static String getSqlQuery(String propertyName) {
        return sqlProperties.getString(propertyName);
    }
}
