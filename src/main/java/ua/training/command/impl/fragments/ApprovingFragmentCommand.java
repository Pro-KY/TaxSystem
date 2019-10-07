package ua.training.command.impl.fragments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.dto.ReportDetailsDto;
import ua.training.service.ReportDetailsService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class ApprovingFragmentCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ApprovingFragmentCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("ApprovingFragmentCommand command");
        final Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));
        log.info("reportApprovalId: {}", reportApprovalId);

        final ReportDetailsDto reportDetails = ReportDetailsService.getInstance().getInspectorReportDetails(reportApprovalId);
        request.setAttribute(Attributes.REPORT_DETAILS, reportDetails);
        request.setAttribute(Attributes.FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_APPROVING));
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
