package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.persistence.entities.Report;
import ua.training.service.EditReportService;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class GetReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(GetReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("getReport command executed");

        final Long reportId = Long.valueOf(request.getParameter(Parameters.REPORT_ID));
        log.info("reportId: {}", reportId);

        final Report report = EditReportService.getInstance().findReportById(reportId);
        CommandAttributesSetter.setEditReportCommandAttributes(request, report);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

