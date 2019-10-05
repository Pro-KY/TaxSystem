package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.dto.PaginationDto;
import ua.training.dto.SentReportsDto;
import ua.training.persistence.dao.jdbc.PaginationHandler;
import ua.training.service.InspectorChangingService;
import ua.training.service.SentReportsService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static ua.training.util.constans.Attributes.SENT_REPORTS_LIST;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class InspectorChangingCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(InspectorChangingCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Long previousInspectorId = Long.valueOf(request.getParameter(Parameters.INSPECTOR_ID));
        Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));

        InspectorChangingService.getInstance().changeInspector(previousInspectorId, reportApprovalId);

        final HttpSession session = request.getSession();
        final PaginationDto currentPaginationDto = (PaginationDto) session.getAttribute(Attributes.PAGINATION_INFO);
        final PaginationHandler<SentReportsDto> paginationHandler = SentReportsService.getInstance().getSentReports(currentPaginationDto);
        final List<SentReportsDto> sentReports = paginationHandler.getPageResult();
        request.setAttribute(SENT_REPORTS_LIST, sentReports);

        CommandAttributesSetter.setInspectorChangingCommandAttributes(request);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

