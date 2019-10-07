package ua.training.command.impl.fragments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class SendReportFragmentCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(SendReportFragmentCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("SendReportFragmentCommand command");

        final HttpSession session = request.getSession();

        log.info("sidebarIndex {}", request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX));
        session.setAttribute(Attributes.SIDEBAR_ACTIVE_INDEX, request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX));

        final String viewPath = getViewPath(FRAGMENT_PATH_SEND_REPORT);
        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
