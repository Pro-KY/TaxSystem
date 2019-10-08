package ua.training.command.impl.fragments;

import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.properties.ViewPropertiesHandler.*;

public class SignUpFragmentCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("SignUpFragmentCommand command");

//        final String viewPath = getViewPath(FRAGMENT_PATH_SIGN_UP);

        final HttpSession session = request.getSession(false);
        if (session != null) {
//            session.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
            session.setAttribute(Attributes.IS_SIGN_UP, true);
        }
        return ViewPropertiesHandler.getViewPath(PATH_INDEX);
    }
}
