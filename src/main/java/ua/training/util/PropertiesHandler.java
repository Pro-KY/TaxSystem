package ua.training.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertiesHandler {

    private static PropertiesHandler instance;
    private ResourceBundle viewsProperties;
    private ResourceBundle sqlProperties;
    private ResourceBundle messageProperties;

    static {
//        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//
//        InputStream inputStream = Thread.currentThread()
//                .getContextClassLoader()
//                .getResourceAsStream("view.properties");
//

//        viewsProperties = ResourceBundle.getBundle("/view.properties", Locale.US, contextClassLoader);
//        viewsProperties = PropertyResourceBundle.getBundle("/view.properties", Locale.US, contextClassLoader);
//        viewsProperties = PropertyResourceBundle.getBundle("/view.properties");
    }

//    private PropertiesHandler() {}

    private PropertiesHandler() {
        viewsProperties = PropertyResourceBundle.getBundle("view");
        sqlProperties = PropertyResourceBundle.getBundle("sql");
    }

    public static PropertiesHandler getInstance() {
        if (instance == null) {
            instance = new PropertiesHandler();
        }

        return instance;
    }

//    public static ResourceBundle getViewProperties() {
//        return viewsProperties = ResourceBundle.getBundle("view.properties");
//    }



    public ResourceBundle getMessageProperties() {
        return messageProperties;
    }


    public ResourceBundle getViewProperties() {
//        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        return viewsProperties = ResourceBundle.getBundle("view");
        return viewsProperties;

//        String currentDirectory = System.getProperty("user.dir");
//        System.out.println("The current working directory is " + currentDirectory);
//        return null;
    }

    public ResourceBundle getSqlProperties() {
//        return loadProperties("sql");
        return sqlProperties;
        // I:\Java\IDEA_projects\epamSummer\TaxSystem\src\main\resources\sql.properties
    }

    private Properties loadProperties(String filePath) {
        Properties prop = null;

        try (InputStream input = getClass().getResourceAsStream(filePath)) {
//        try (InputStream input = new FileInputStream(filePath)) {

            prop = new Properties();

            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
