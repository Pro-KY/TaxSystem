package ua.training.util.handler.properties;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class SqlPropertiesHandler {
    private static ResourceBundle sqlProperties;
    public static final String LOGIN_AND_PASSWORD = "getByLoginAndPassword";
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
