package ua.training.command.impl;

import ua.training.command.ICommand;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;


public class EmptyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ViewPropertiesHandler.getViewPath(ViewPropertiesHandler.FRAGMENT_PATH_SIGN_IN);
    }
}
