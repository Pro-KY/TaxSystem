package ua.training.command.fragments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class ReportFragmentCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ReportFragmentCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("ReportFragmentCommand command");

        log.info("sidebarIndex {}", request.getParameter("sidebarIndex"));
        request.setAttribute(Attributes.SIDEBAR_ACTIVE_INDEX, request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX));

        final String viewPath = getViewPath(FRAGMENT_PATH_SEND_REPORT);
        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
//        request.setAttribute(ALERT, true);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
