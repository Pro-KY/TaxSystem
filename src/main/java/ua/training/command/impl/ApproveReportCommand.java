package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.service.ReportApprovalService;
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
        final Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));
        final String refusalCause = request.getParameter(Parameters.REFUSAL_CAUSE);
        final Long stateApprovalId = Long.valueOf(request.getParameter(Parameters.REPORTS_APPROVAL_TYPE));

        ReportApprovalService.getInstance().updateReportApproval(reportApprovalId, refusalCause, stateApprovalId);

        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
