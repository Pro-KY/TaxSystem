package ua.training.command.impl;

import ua.training.command.ICommand;
import ua.training.util.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.properties.ViewPropertiesHandler.*;

public class SignOutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return ViewPropertiesHandler.getViewPath(PATH_INDEX);
    }
}
