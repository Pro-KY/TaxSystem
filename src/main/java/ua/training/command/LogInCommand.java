package ua.training.command;

import ua.training.persistance.beans.User;
import ua.training.util.Param;
import ua.training.service.AuthorizationService;
import ua.training.util.handler.properties.MessagePropertiesHandler;
import ua.training.util.handler.properties.ViewProperiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import static ua.training.util.handler.properties.MessagePropertiesHandler.LOGIN_ERROR;
import static ua.training.util.handler.properties.ViewProperiesHandler.PATH_ERROR;
import static ua.training.util.handler.properties.ViewProperiesHandler.PATH_MAIN;

public class LogInCommand implements ICommand {
    AuthorizationService authorizationService;

//    static {
//        propertiesHandler = PropertiesHandler.getInstance();
//    }

    public LogInCommand() {
        this.authorizationService = new AuthorizationService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String propertyName;

//        RequestContent requestContent = new RequestContent(request);
//        requestContent.extractAuthenticationValues();
        final String login = request.getParameter(Param.LOGIN);
        final String password = request.getParameter(Param.PASSWORD);

        final Optional<User> optionalUser = authorizationService.authorizeUser(login, password);
//        final ResourceBundle viewProperties = propertiesHandler.getViewProperties();

        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            request.setAttribute("id", user.getId());
            request.setAttribute("firstName", user.getFirstName());
            request.setAttribute("lastName", user.getLastName());
            propertyName = PATH_MAIN;
            final HttpSession session = request.getSession(true);
            session.setAttribute("role", user.getUserType().getType());
        } else {
            propertyName = PATH_ERROR;
            request.setAttribute("errorMsg", MessagePropertiesHandler.getMessage(LOGIN_ERROR));
        }

        return ViewProperiesHandler.getViewPath(propertyName);
    }
}
