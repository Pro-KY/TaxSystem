package ua.training.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public void extractValues(HttpServletRequest request) {

    }

    // метод добавления в запрос данных для передачи в jsp
    public void insertAttributes(HttpServletRequest request) {

    }
}
