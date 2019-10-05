package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.dto.PaginationDto;
import ua.training.dto.ReportDto;
import ua.training.dto.SentReportsDto;
import ua.training.persistence.dao.jdbc.PaginationHandler;
import ua.training.service.EditReportService;
import ua.training.service.SentReportsService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static ua.training.util.constans.Attributes.SENT_REPORTS_LIST;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

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
            final PaginationHandler<SentReportsDto> paginationHandler = SentReportsService.getInstance().getSentReports(currentPaginationDto);
            final List<SentReportsDto> sentReports = paginationHandler.getPageResult();
            request.setAttribute(SENT_REPORTS_LIST, sentReports);
            isOperationSuccessful = true;
        } catch (Exception e) {
            isOperationSuccessful = false;
        }

        CommandAttributesSetter.setEditReportCommandAttributes(request, reportDto, isOperationSuccessful);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

