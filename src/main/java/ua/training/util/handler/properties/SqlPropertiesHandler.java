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



//    public static final String PASSWORD = "colummn.password";
//    public static final String FIRST_NAME = "colummn.first_name";
//    public static final String LAST_NAME = "colummn.last_name";
//    public static final String EMAIL = "colummn.email";
//    public static final String ADDRESS = "colummn.address";
//    public static final String IS_PHYSICAL = "colummn.is_physical";
//    public static final String USER_TYPE_ID = "colummn.user_type_id";

    static {
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static String getSqlQuery(String propertyName) {
        return sqlProperties.getString(propertyName);
    }
}
