package ua.training.command;

import ua.training.util.handler.properties.ViewProperiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewProperiesHandler.*;

public class LogOutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return ViewProperiesHandler.getViewPath(PATH_INDEX);
    }
}
