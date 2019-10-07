package ua.training.command.impl;

import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class EmptyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {

        final HttpSession session = request.getSession(false);
        boolean isAuthorized = false;
        if (session != null) {
            isAuthorized = (boolean) session.getAttribute(Attributes.IS_USER_AUTHORIZED);
        }

        String property = isAuthorized ? ViewPropertiesHandler.PATH_MAIN : ViewPropertiesHandler.PATH_INDEX;
        return ViewPropertiesHandler.getViewPath(property);
    }
}
