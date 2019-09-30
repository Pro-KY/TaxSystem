package ua.training.command;

import ua.training.persistance.entities.User;
import ua.training.service.SignInService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.MessagePropertiesHandler;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static ua.training.util.handler.properties.MessagePropertiesHandler.LOGIN_ERROR;
import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class SignInCommand implements ICommand {
    private SignInService signInService;

    SignInCommand() {
        this.signInService = new SignInService();
    }

    @Override
    public String execute(HttpServletRequest request) {

        final String email = request.getParameter(Parameters.EMAIL);
        final String password = request.getParameter(Parameters.PASSWORD);

        //TODO: validate request params here or on the frontend
        final Optional<User> optionalUser = signInService.getAuthorizedUser(email, password);
        boolean isUserAuthorized = optionalUser.isPresent();

        String pagePathProperty = isUserAuthorized ? PATH_MAIN : PATH_ERROR;
        final HttpSession session = request.getSession(false);

        if (session != null) {
            session.setAttribute(Attributes.IS_USER_AUTHORIZED, isUserAuthorized);

            if (isUserAuthorized) {
                final User user = optionalUser.get();
                session.setAttribute(Attributes.USER, user);
                request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SEND_REPORT));
            } else {
                request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(PATH_ERROR));
                request.setAttribute(Attributes.ERROR_MSG, MessagePropertiesHandler.getMessage(LOGIN_ERROR));
            }
        }

        return ViewPropertiesHandler.getViewPath(pagePathProperty);
    }
}
