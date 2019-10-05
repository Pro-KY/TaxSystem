package ua.training.command.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.DtoMapper;
import ua.training.dto.ReportDto;
import ua.training.persistence.entities.Report;
import ua.training.service.ReportDetailsService;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constans.Attributes.*;
import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class CommandAttributesSetter {
    private static final Logger log = LogManager.getLogger(ReportDetailsService.class);

    public static String getErrorPage(HttpServletRequest request, String msg) {
        request.setAttribute(ALERT_ERROR, true);
        return ViewPropertiesHandler.getViewPath(PATH_ERROR);
    }

    public static void setSendReportCommandAttributes(HttpServletRequest request) {
        request.setAttribute(ALERT_SUCCESS, true);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SEND_REPORT));
    }

    public static void setGetReportCommandAttributes(HttpServletRequest request, Report report, Long reportApprovalId) {
        final ReportDto reportDto = DtoMapper.getInstance().mapToReportDto(report);
        reportDto.setReportApprovalId(reportApprovalId);
        request.setAttribute(REPORT_DTO, reportDto);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_EDIT_REPORT));
    }

    public static void setEditReportCommandAttributes(HttpServletRequest request, boolean isOperationSuccessful) {
        request.setAttribute(ALERT_SUCCESS, isOperationSuccessful);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
    }
}
