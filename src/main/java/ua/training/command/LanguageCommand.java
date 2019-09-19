package ua.training.command;

import ua.training.util.handler.properties.ViewProperiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import java.util.Locale;

import static ua.training.util.handler.properties.ViewProperiesHandler.PATH_INDEX;

public class LanguageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        final String chosenLanguage = request.getParameter("language");
        final HttpSession session = request.getSession(true);
        session.setAttribute("language", chosenLanguage);
//        Config.set(session, Config.FMT_LOCALE, Locale.forLanguageTag(chosenLanguage));

        return ViewProperiesHandler.getViewPath(PATH_INDEX);
    }
}

