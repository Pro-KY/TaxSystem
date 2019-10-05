package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SqlPropertiesHandler {
    private static ResourceBundle sqlProperties;
    public static final String LOGIN_AND_PASSWORD = "LOGIN_AND_PASSWORD";
    public static final String FIND_TAX_TYPE_BY_NAME = "FIND_TAX_TYPE_BY_NAME";
    public static final String FIND_ALL_TAX_TYPES = "FIND_ALL_TAX_TYPES";
    public static final String FIND_REPORT_STATE_BY_NANE = "FIND_REPORT_STATE_BY_NANE";
    public static final String SAVE_REPORT = "SAVE_REPORT";
    public static final String SAVE_REPORT_APPROVAL = "SAVE_REPORT_APPROVAL";
    public static final String SAVE_USER = "SAVE_USER";
    public static final String FIND_USER_BY_ID = "FIND_USER_BY_ID";
    public static final String FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID = "FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID";
    public static final String USER_TYPE_BY_TYPE = "USER_TYPE_BY_TYPE";

    public static final String REPORT_APPROVAL_PAGINATION = "REPORT_APPROVAL_PAGINATION";
    public static final String REPORT_APPROVAL_COUNT = "REPORT_APPROVAL_COUNT";
    public static final String REPORT_APPROVAL_WITH_RELATIONS_BY_ID = "REPORT_APPROVAL_WITH_RELATIONS_BY_ID";
    public static final String FIND_REPORT_BY_ID = "FIND_REPORT_BY_ID";
    public static final String UPDATE_REPORT_BY_ID = "UPDATE_REPORT_BY_ID";
    public static final String FIND_REPORT_APPROVAL_BY_ID = "FIND_REPORT_APPROVAL_BY_ID";
    public static final String UPDATE_REPORT_APPROVAL_BY_ID = "UPDATE_REPORT_APPROVAL_BY_ID";

    public static final String SAVE_INSPECTOR_CHANGING = "SAVE_INSPECTOR_CHANGING";

    static {
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static String getSqlQuery(String propertyName) {
        return sqlProperties.getString(propertyName);
    }
}
