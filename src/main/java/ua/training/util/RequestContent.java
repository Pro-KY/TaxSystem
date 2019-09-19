package ua.training.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

// holds all logic for extracting parameters from request and putting
public class RequestContent {
    private HttpServletRequest request;
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String> requestParameters;

//    private static String PARAM_NAME_LOGIN = "login";
//    private HashMap<String, Object> sessionAttributes;
//    private HashMap<String, T> requestAttributes; ??

    public RequestContent(HttpServletRequest request) {
        this.request = request;
        this.requestAttributes = new HashMap<>();
        this.requestParameters = new HashMap<>();
    }

    public void extractAuthenticationValues() {
        final String login = request.getParameter(Parameter.LOGIN);
        final String password = request.getParameter(Parameter.PASSWORD);
        // TODO: handle case when values are null or absent
        requestParameters.put(Parameter.LOGIN, login);
        requestParameters.put(Parameter.PASSWORD, password);
    }

    // метод добавления в запрос данных для передачи в jsp
    public void setAttribute(String attribute, Object value) {
        request.setAttribute(attribute, value);
//        requestAttributes.put(attribute, value);
    }

    public HashMap<String, Object> getRequestAttributes() {
        return requestAttributes;
    }

    public HashMap<String, String> getRequestParameters() {
        return requestParameters;
    }
}
