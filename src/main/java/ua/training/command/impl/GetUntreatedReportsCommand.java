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
import ua.training.util.constans.StateApprovalEnum;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

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
        final PaginationDto currentPaginationDto = CommandUtil.getInstance().getCurrentPaginationDto(session);
        currentPaginationDto.setPaginationRequestContent(request);

        final Long approvalReportsTypeId = currentPaginationDto.getApprovalReportsTypeId();
        final StateApproval stateApproval = new StateApproval(approvalReportsTypeId);

        PaginationDto updatedPaginationDto;

        if(approvalReportsTypeId.equals(StateApprovalEnum.PROCESSING.getStateId())) {
            updatedPaginationDto = reportApprovalService.getUntreatedReportsForInspector(currentPaginationDto, stateApproval);
        } else {
            final User inspector = (User) session.getAttribute(Attributes.USER);
            updatedPaginationDto = reportApprovalService.getChangedReportsForInspector(currentPaginationDto, stateApproval, inspector);
        }

        session.setAttribute(Attributes.PAGINATION_INFO, updatedPaginationDto);

        final String viewPath = getViewPath(FRAGMENT_PATH_SENT_REPORTS);
        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
