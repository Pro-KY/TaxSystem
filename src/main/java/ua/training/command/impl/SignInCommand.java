package ua.training.command.impl;

import ua.training.command.ICommand;
import ua.training.persistence.entities.User;
import ua.training.service.SignInService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.constans.UserTypes;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class SignInCommand implements ICommand {
    private SignInService signInService;

    public SignInCommand() {
        this.signInService = new SignInService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String email = request.getParameter(Parameters.EMAIL);
        final String password = request.getParameter(Parameters.PASSWORD);

        final Optional<User> optionalUser = signInService.getAuthorizedUser(email, password);
        boolean isUserAuthorized = optionalUser.isPresent();

        String pagePathProperty = isUserAuthorized ? PATH_MAIN : PATH_ERROR;
        final HttpSession session = request.getSession(false);

        if (session != null) {
            session.setAttribute(Attributes.IS_USER_AUTHORIZED, isUserAuthorized);

            if (isUserAuthorized) {
                final User user = optionalUser.get();
                session.setAttribute(Attributes.USER, user);
                final String type = user.getUserType().getType();
                String fragmentPath = type.equals(UserTypes.INSPECTOR.getType()) ? FRAGMENT_PATH_SENT_REPORTS : FRAGMENT_PATH_SEND_REPORT;
                request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(fragmentPath));
            } else {
                request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(PATH_ERROR));
                request.setAttribute(Attributes.ALERT_ERROR, true);
            }
        }

        return ViewPropertiesHandler.getViewPath(pagePathProperty);
    }
}
