package ua.training.command;

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
//        Config.set(session, Config.FMT_LOCALE, Locale.forLanguageTag(chosenLanguage));

        return ViewPropertiesHandler.getViewPath(PATH_INDEX);
    }
}

