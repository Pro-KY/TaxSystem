package ua.training.command;

import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_LOGIN;

public class EmptyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ViewPropertiesHandler.getViewPath(PATH_LOGIN);
    }
}
