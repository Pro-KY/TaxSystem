package ua.training.command;

import ua.training.persistance.beans.User;
import ua.training.persistance.dao.mappers.UserBeanMapperImpl;
import ua.training.service.SignInService;
import ua.training.util.handler.properties.MessagePropertiesHandler;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import static ua.training.util.handler.properties.MessagePropertiesHandler.LOGIN_ERROR;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_ERROR;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class SignInCommand implements ICommand {
    private SignInService signInService;

    SignInCommand() {
        this.signInService = new SignInService();
    }

    @Override
    public String execute(HttpServletRequest request) {

        final String email = request.getParameter(UserBeanMapperImpl.EMAIL);
        final String password = request.getParameter(UserBeanMapperImpl.PASSWORD);

        //TODO: validate request params
        final Optional<User> optionalUser = signInService.getAuthorizedUser(email, password);
        boolean isUserAuthorized = optionalUser.isPresent();

        String pagePathProperty = isUserAuthorized ? PATH_MAIN : PATH_ERROR;
        final HttpSession session = request.getSession(true);
        session.setAttribute("isUserAuthorized", isUserAuthorized);

        if (isUserAuthorized) {
            final User user = optionalUser.get();
            session.setAttribute("user", user);
        } else {
            request.setAttribute("errorMsg", MessagePropertiesHandler.getMessage(LOGIN_ERROR));
        }

        return ViewPropertiesHandler.getViewPath(pagePathProperty);
    }
}
