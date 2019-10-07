package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

// for inspector
public class ApproveReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ApproveReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("approve report command");
        final String reportApprovalId = request.getParameter(Parameters.REPORT_APPROVAL_ID);
        final String refusalCause = request.getParameter(Parameters.REFUSAL_CAUSE);
        final String stateApprovalId = request.getParameter(Parameters.REPORTS_APPROVAL_TYPE);
        System.out.println(stateApprovalId);

//        final String viewPath = getViewPath(FRAGMENT_PATH_SENT_REPORTS);
//        final String sideBarIndex = request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX);
//
//        final HttpSession session = request.getSession();
//
//        if (sideBarIndex != null) {
//            session.setAttribute(Attributes.SIDEBAR_ACTIVE_INDEX, request.getParameter(Parameters.SIDEBAR_ACTIVE_INDEX));
//        }
//
//        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
