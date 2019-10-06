package ua.training.command.impl;

import ua.training.command.ICommand;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_INDEX;

public class LanguageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        final String chosenLanguage = request.getParameter("language");

        final HttpSession session = request.getSession(true);
        session.setAttribute("language", chosenLanguage);

        return ViewPropertiesHandler.getViewPath(PATH_INDEX);
    }
}

