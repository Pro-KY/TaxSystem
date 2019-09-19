package ua.training.command;

import ua.training.util.handler.properties.ViewProperiesHandler;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ViewProperiesHandler.getViewPath("path.page.login");
    }
}
