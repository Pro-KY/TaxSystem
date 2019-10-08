package ua.training.command.impl;

import ua.training.command.ICommand;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.properties.ViewProperties.PATH_INDEX;

public class LanguageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        final String chosenLanguage = request.getParameter("language");

        final HttpSession session = request.getSession(true);
        session.setAttribute("language", chosenLanguage);

        return ViewProperties.getViewPath(PATH_INDEX);
    }
}

