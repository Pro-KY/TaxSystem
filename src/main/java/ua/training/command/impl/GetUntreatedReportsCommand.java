package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandUtil;
import ua.training.dto.PaginationDto;
import ua.training.persistence.entities.StateApproval;
import ua.training.persistence.entities.User;
import ua.training.service.ReportApprovalService;
import ua.training.util.constans.Attributes;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.properties.ViewProperties.*;

public class GetUntreatedReportsCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(GetUntreatedReportsCommand.class);
    private ReportApprovalService reportApprovalService;

    public GetUntreatedReportsCommand() {
        this.reportApprovalService = ReportApprovalService.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request) {
        log.info("in GetUntreatedReportsCommand command");
        final HttpSession session = request.getSession();
        final Long reportsApprovalTypeId = CommandUtil.getInstance().getReportsApprovalTypeId(session, request);

        final PaginationDto currentPaginationDto = CommandUtil.getInstance().getCurrentPaginationDto(session);
        currentPaginationDto.setPaginationRequestContent(request);

        final StateApproval stateApproval = new StateApproval(reportsApprovalTypeId);
        final User inspector = (User) session.getAttribute(Attributes.USER);
        PaginationDto updatedPaginationDto = reportApprovalService.getUntreatedReports(currentPaginationDto, stateApproval, inspector);

        session.setAttribute(Attributes.PAGINATION_INFO, updatedPaginationDto);

        final String viewPath = getViewPath(FRAGMENT_PATH_SENT_REPORTS);
        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
        return ViewProperties.getViewPath(PATH_MAIN);
    }
}
