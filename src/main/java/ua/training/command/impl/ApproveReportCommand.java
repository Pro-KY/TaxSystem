package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandUtil;
import ua.training.dto.PaginationDto;
import ua.training.service.ReportApprovalService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.constans.Attributes.ALERT_ERROR;
import static ua.training.util.constans.Attributes.ALERT_SUCCESS;
import static ua.training.util.properties.ViewProperties.*;

public class ApproveReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ApproveReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("approve report command");
        final Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));
        final String refusalCause = request.getParameter(Parameters.REFUSAL_CAUSE);
        final Long stateApprovalId = Long.valueOf(request.getParameter(Parameters.REPORTS_APPROVAL_TYPE));
        final HttpSession session = request.getSession();
        final PaginationDto currentPaginationDto = CommandUtil.getInstance().getCurrentPaginationDto(session);

        boolean isOperationSuccessful;

        try {
            ReportApprovalService.getInstance().updateReportApproval(reportApprovalId, refusalCause, stateApprovalId);
            isOperationSuccessful = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            isOperationSuccessful = false;
        }

        String attributeName = isOperationSuccessful ? ALERT_SUCCESS : ALERT_ERROR;
        request.setAttribute(attributeName, true);

        session.setAttribute(Attributes.PAGINATION_INFO, currentPaginationDto);
        request.setAttribute(Attributes.FRAGMENT_PATH, getViewPath(FRAGMENT_PATH_SENT_REPORTS));
        return ViewProperties.getViewPath(PATH_MAIN);
    }
}
