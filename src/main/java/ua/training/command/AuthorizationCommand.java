package ua.training.command;

import ua.training.persistance.beans.User;
import ua.training.persistance.util.Param;
import ua.training.service.AuthorizationService;
import ua.training.util.PropertiesHandler;
import ua.training.util.handler.properties.MessageProperty;
import ua.training.util.handler.properties.ViewProperty;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import static ua.training.util.handler.properties.MessageProperty.LOGIN_ERROR;
import static ua.training.util.handler.properties.ViewProperty.PATH_ERROR;
import static ua.training.util.handler.properties.ViewProperty.PATH_MAIN;

public class AuthorizationCommand implements ICommand {
    AuthorizationService authorizationService;
    private static PropertiesHandler propertiesHandler;

//    static {
//        propertiesHandler = PropertiesHandler.getInstance();
//    }

    public AuthorizationCommand() {
        this.authorizationService = new AuthorizationService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String propertyName;

//        RequestContent requestContent = new RequestContent(request);
//        requestContent.extractAuthenticationValues();

        final String login = request.getParameter(Param.LOGIN);
        final String password = request.getParameter(Param.PASSWORD);

        final Optional<User> optionalUser = authorizationService.getAuthorizedUser(login, password);
//        final ResourceBundle viewProperties = propertiesHandler.getViewProperties();

        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            request.setAttribute("id", user.getId());
            request.setAttribute("firstName", user.getFirstName());
            request.setAttribute("lastName", user.getLastName());
            propertyName = PATH_MAIN;
        } else {
            propertyName = PATH_ERROR;
            request.setAttribute("errorMsg", MessageProperty.getMessage(LOGIN_ERROR));
        }

        return ViewProperty.getViewPath(propertyName);
    }
}
