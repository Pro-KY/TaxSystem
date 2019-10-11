package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.command.util.CommandUtil;
import ua.training.dto.PaginationDto;
import ua.training.dto.ReportDetailsDto;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.User;
import ua.training.service.ReportApprovalService;
import ua.training.util.constans.Attributes;
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
        final CommandParametersExtractor paramsExtractor = CommandParametersExtractor.getInstance();
        final ReportDetailsDto reportDetailsDto = paramsExtractor.extractParameters(request, ReportDetailsDto.class);

        final HttpSession session = request.getSession();
        PaginationDto currentPaginationDto = CommandUtil.getInstance().getCurrentPaginationDto(session);
        final User inspector = (User) session.getAttribute(Attributes.USER);
        final Long stateApprovalId = reportDetailsDto.getStateApprovalId();
        log.info("stateApprovalId = {}", stateApprovalId);
        final Long reportsApprovalTypeId = CommandUtil.getInstance().getReportsApprovalTypeId(session, request);

        boolean isOperationSuccessful;

        try {
            final ReportApprovalService reportApprovalService = ReportApprovalService.getInstance();
            reportApprovalService.updateReportApproval(reportDetailsDto.getReportApprovalId(), reportDetailsDto.getRefusalCause(), stateApprovalId);
            currentPaginationDto = reportApprovalService.getSentReportApprovals(currentPaginationDto, new StateApproval(reportsApprovalTypeId), inspector);
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
