package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.command.CommandAttributesSetter;
import ua.training.dto.PaginationDto;
import ua.training.persistence.entities.ReportApproval;
import ua.training.service.InspectorChangingService;
import ua.training.service.ReportApprovalService;
import ua.training.util.constans.Parameters;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.constans.Attributes.PAGINATION_INFO;
import static ua.training.util.properties.ViewProperties.PATH_MAIN;

public class InspectorChangingCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(InspectorChangingCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Long previousInspectorId = Long.valueOf(request.getParameter(Parameters.INSPECTOR_ID));
        Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));

        InspectorChangingService.getInstance().changeInspector(previousInspectorId, reportApprovalId);
        final HttpSession session = request.getSession();
        final PaginationDto currentPaginationDto = (PaginationDto) session.getAttribute(PAGINATION_INFO);
        final ReportApprovalService reportApprovalService = ReportApprovalService.getInstance();
        final ReportApproval reportApproval = reportApprovalService.getReportApprovalById(reportApprovalId);
        final PaginationDto paginationHandler = reportApprovalService.getReportsApprovalForUser(currentPaginationDto, reportApproval.getUser().getId());
        request.setAttribute(PAGINATION_INFO, paginationHandler);

        CommandAttributesSetter.getInstance().setInspectorChangingCommandAttributes(request);
        return ViewProperties.getViewPath(PATH_MAIN);
    }
}

