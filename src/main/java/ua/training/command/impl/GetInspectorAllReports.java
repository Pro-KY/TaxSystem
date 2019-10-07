package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.service.ReportApprovalService;
import ua.training.util.constans.Attributes;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class GetInspectorAllReports implements ICommand {
    private static final Logger log = LogManager.getLogger(GetInspectorAllReports.class);
    private ReportApprovalService reportApprovalService;

    public GetInspectorAllReports() {
        this.reportApprovalService = ReportApprovalService.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String allReportsType = request.getParameter(Parameters.INSPECTOR_ALL_REPORTS_TYPE);
        log.info("allReportsType {}", allReportsType);

        final String viewPath = getViewPath(FRAGMENT_PATH_SENT_REPORTS);
        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
