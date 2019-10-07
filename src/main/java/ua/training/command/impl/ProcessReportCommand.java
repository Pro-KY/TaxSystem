package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

// for inspector
public class ProcessReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ProcessReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("process report command");
        final String viewPath = getViewPath(FRAGMENT_PATH_SENT_REPORTS);
        final String sideBarIndex = request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX);

        final HttpSession session = request.getSession();

        if (sideBarIndex != null) {
            session.setAttribute(Attributes.SIDEBAR_ACTIVE_INDEX, request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX));
        }

        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
