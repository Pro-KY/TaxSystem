package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.dto.ReportDto;
import ua.training.service.EditReportService;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

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

        EditReportService.getInstance().updateReport(reportDto, reportApprovalId);
        CommandAttributesSetter.setEditReportCommandAttributes(request);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

