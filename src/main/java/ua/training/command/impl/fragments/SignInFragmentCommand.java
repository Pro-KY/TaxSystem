package ua.training.command.impl.fragments;

import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.properties.ViewProperties.PATH_INDEX;

public class SignInFragmentCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(Attributes.IS_SIGN_UP_FRAGMENT, false);
        return ViewProperties.getViewPath(PATH_INDEX);
    }
}
