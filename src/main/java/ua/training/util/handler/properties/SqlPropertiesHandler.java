package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SqlPropertiesHandler {
    private static ResourceBundle sqlProperties;

    public static final String FIND_BY_LOGIN_AND_PASSWORD = "FIND_BY_LOGIN_AND_PASSWORD";
    public static final String FIND_TAX_TYPE_BY_NAME = "FIND_TAX_TYPE_BY_NAME";
    public static final String FIND_ALL_TAX_TYPES = "FIND_ALL_TAX_TYPES";
    public static final String FIND_REPORT_STATE_BY_NANE = "FIND_REPORT_STATE_BY_NANE";
    public static final String SAVE_REPORT = "SAVE_REPORT";
    public static final String SAVE_REPORT_APPROVAL = "SAVE_REPORT_APPROVAL";
    public static final String SAVE_USER = "SAVE_USER";
    public static final String FIND_USER_BY_ID = "FIND_USER_BY_ID";
    public static final String FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID = "FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID";
    public static final String USER_TYPE_BY_TYPE = "USER_TYPE_BY_TYPE";

    public static final String REPORT_APPROVAL_FOR_USER = "REPORT_APPROVAL_FOR_USER";
    public static final String REPORT_APPROVAL_BY_APPROVAL_STATE = "REPORT_APPROVAL_BY_APPROVAL_STATE";
    public static final String REPORT_APPROVAL_COUNT_FOR_USER = "REPORT_APPROVAL_COUNT_FOR_USER";
    public static final String REPORT_APPROVAL_JOIN_REPORT_JOIN_INSPECTOR = "REPORT_APPROVAL_JOIN_REPORT_JOIN_INSPECTOR";
    public static final String REPORT_APPROVAL_JOIN_REPORT_JOIN_USER = "REPORT_APPROVAL_JOIN_REPORT_JOIN_USER";
    public static final String REPORT_APPROVAL_JOIN_USER = "REPORT_APPROVAL_JOIN_USER";
    public static final String FIND_REPORT_APPROVAL_BY_ID = "FIND_REPORT_APPROVAL_BY_ID";
    public static final String UPDATE_REPORT_APPROVAL_BY_ID = "UPDATE_REPORT_APPROVAL_BY_ID";
    public static final String COUNT_ALL_REPORT_APPROVAL_BY_STATE_APPROVAL = "COUNT_ALL_REPORT_APPROVAL_BY_STATE_APPROVAL";
    public static final String REPORT_APPROVAL_BY_APPROVAL_STATE_AND_INSPECTOR_ID = "REPORT_APPROVAL_BY_APPROVAL_STATE_AND_INSPECTOR_ID";
    public static final String COUNT_ALL_REPORT_APPROVAL_BY_STATE_APPROVAL_AND_INSPECTOR_ID = "COUNT_ALL_REPORT_APPROVAL_BY_STATE_APPROVAL_AND_INSPECTOR_ID";


    public static final String FIND_REPORT_BY_ID = "FIND_REPORT_BY_ID";
    public static final String UPDATE_REPORT_BY_ID = "UPDATE_REPORT_BY_ID";

    public static final String SAVE_INSPECTOR_CHANGING = "SAVE_INSPECTOR_CHANGING";

    static {
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static String getSqlQuery(String propertyName) {
        return sqlProperties.getString(propertyName);
    }
}
