package ua.training.util.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SqlProperties {
    private static ResourceBundle sqlProperties;

    public static final String FIND_TAX_TYPE_BY_NAME = "FIND_TAX_TYPE_BY_NAME";
    public static final String FIND_ALL_TAX_TYPES = "FIND_ALL_TAX_TYPES";

    public static final String SAVE_TAX_TYPE = "SAVE_TAX_TYPE";
    public static final String UPDATE_TAX_TYPE = "UPDATE_TAX_TYPE";
    public static final String DELETE_TAX_TYPE = "DELETE_TAX_TYPE";
    public static final String FIND_TAX_TYPE_BY_ID = "FIND_TAX_TYPE_BY_ID";

    public static final String FIND_STATE_APPROVAL_BY_STATE = "FIND_STATE_APPROVAL_BY_STATE";
    public static final String SAVE_STATE_APPROVAL = "SAVE_STATE_APPROVAL";
    public static final String UPDATE_STATE_APPROVAL = "UPDATE_STATE_APPROVAL";
    public static final String DELETE_STATE_APPROVAL = "DELETE_STATE_APPROVAL";
    public static final String FIND_STATE_APPROVAL_BY_ID = "FIND_STATE_APPROVAL_BY_ID";

    public static final String SAVE_REPORT = "SAVE_REPORT";
    public static final String DELETE_REPORT_BY_ID = "DELETE_REPORT_BY_ID";
    public static final String FIND_REPORT_BY_ID = "FIND_REPORT_BY_ID";
    public static final String UPDATE_REPORT_BY_ID = "UPDATE_REPORT_BY_ID";

    public static final String FIND_BY_LOGIN_AND_PASSWORD = "FIND_BY_LOGIN_AND_PASSWORD";
    public static final String SAVE_USER = "SAVE_USER";
    public static final String FIND_USER_BY_ID = "FIND_USER_BY_ID";
    public static final String FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID = "FIND_USER_BY_USER_TYPE_AND_NOT_EQUAL_ID";
    public static final String USER_TYPE_BY_TYPE = "USER_TYPE_BY_TYPE";
    public static final String UPDATE_USER = "UPDATE_USER";
    public static final String DELETE_USER_BY_ID = "DELETE_USER_BY_ID";

    public static final String SAVE_REPORT_APPROVAL = "SAVE_REPORT_APPROVAL";
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
    public static final String DELETE_REPORT_APPROVAL_BY_ID = "DELETE_REPORT_APPROVAL_BY_ID";

    public static final String UPDATE_INSPECTOR_CHANGING_BY_ID = "UPDATE_INSPECTOR_CHANGING_BY_ID";
    public static final String DELETE_INSPECTOR_CHANGING_BY_ID = "DELETE_INSPECTOR_CHANGING_BY_ID";
    public static final String FIND_INSPECTOR_CHANGING_BY_ID = "FIND_INSPECTOR_CHANGING_BY_ID";

    public static final String SAVE_INSPECTOR_CHANGING = "SAVE_INSPECTOR_CHANGING";

    static {
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static String getSqlQuery(String propertyName) {
        return sqlProperties.getString(propertyName);
    }
}
