package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.dto.PaginationDto;
import ua.training.dto.ReportDto;
import ua.training.persistence.entities.ReportApproval;
import ua.training.service.EditReportService;
import ua.training.service.ReportApprovalService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.properties.ViewPropertiesHandler.PATH_MAIN;

public class EditReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(EditReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("editReport command executed");
        ReportDto reportDto = CommandParametersExtractor.getInstance().extractParameters(request, ReportDto.class);

        final Long reportId = Long.valueOf(request.getParameter(Parameters.REPORT_ID));
        final Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));
        log.info("reportId: {}", reportId);
        log.info("reportApprovalId: {}", reportApprovalId);

        final HttpSession session = request.getSession();
        final PaginationDto currentPaginationDto = (PaginationDto) session.getAttribute(Attributes.PAGINATION_INFO);

        boolean isOperationSuccessful;

        try {
            EditReportService.getInstance().updateReport(reportDto, reportApprovalId);

            final ReportApprovalService reportApprovalService = ReportApprovalService.getInstance();
            final ReportApproval reportApproval = reportApprovalService.getReportApprovalById(reportApprovalId);
            final PaginationDto updatedPaginationDto = reportApprovalService.getReportsApprovalForUser(currentPaginationDto, reportApproval.getUser().getId());
            request.setAttribute(Attributes.PAGINATION_INFO, updatedPaginationDto);
            isOperationSuccessful = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            isOperationSuccessful = false;
        }

        CommandAttributesSetter.setEditReportCommandAttributes(request, reportDto, isOperationSuccessful);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

