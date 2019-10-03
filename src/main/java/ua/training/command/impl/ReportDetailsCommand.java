package ua.training.command.impl;

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

public class ReportDetailsCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ReportDetailsCommand.class);

    ReportDetailsService reportDetailsService;

    @Override
    public String execute(HttpServletRequest request) {
        final String parameter = request.getParameter(Parameters.REPORT_APPROVAL_ID);
        log.info("id - {}", parameter);
        final Long reportApprovalId = Long.valueOf(parameter);
        final ReportDetailsDto reportDetails = ReportDetailsService.getInstance().getReportDetails(reportApprovalId);

        final String fragmentPath = getViewPath(FRAGMENT_PATH_REPORT_DETAILS);

        request.setAttribute(Attributes.REPORT_DETAILS, reportDetails);
        request.setAttribute(Attributes.FRAGMENT_PATH, fragmentPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
