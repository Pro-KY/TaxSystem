package ua.training.command.impl.fragments;

import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.properties.ViewProperties.*;

public class SignInFragmentCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("SignInFragmentCommand command");

//        final String viewPath = getViewPath(FRAGMENT_PATH_SIGN_IN);

        final HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute(Attributes.IS_SIGN_UP, false);
        }
        return ViewProperties.getViewPath(PATH_INDEX);
    }
}
