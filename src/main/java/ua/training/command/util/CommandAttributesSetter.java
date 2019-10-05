package ua.training.command.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.DtoMapper;
import ua.training.dto.ReportDto;
import ua.training.persistence.entities.Report;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constans.Attributes.*;
import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class CommandAttributesSetter {
    private static final Logger log = LogManager.getLogger(CommandAttributesSetter.class);

    public static String getErrorPage(HttpServletRequest request, String msg) {
        request.setAttribute(ALERT_ERROR, true);
        return ViewPropertiesHandler.getViewPath(PATH_ERROR);
    }

    public static void setSendReportCommandAttributes(HttpServletRequest request, boolean isOperationSuccessful) {
        String attributeName = isOperationSuccessful ? ALERT_SUCCESS : ALERT_ERROR;
        request.setAttribute(attributeName, true);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SEND_REPORT));
    }

    public static void setGetReportCommandAttributes(HttpServletRequest request, Report report, Long reportApprovalId) {
        final ReportDto reportDto = DtoMapper.getInstance().mapToReportDto(report);
        reportDto.setReportApprovalId(reportApprovalId);
        request.setAttribute(REPORT_DTO, reportDto);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_EDIT_REPORT));
    }

    public static void setEditReportCommandAttributes(HttpServletRequest request, ReportDto reportDto, boolean isOperationSuccessful) {
        if(isOperationSuccessful) {
            request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
        } else {
            request.setAttribute(REPORT_DTO, reportDto);
            request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_EDIT_REPORT));
        }

        String attributeName = isOperationSuccessful ? ALERT_SUCCESS : ALERT_ERROR;
        request.setAttribute(attributeName, true);
    }

    public static void setInspectorChangingCommandAttributes(HttpServletRequest request) {
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
        request.setAttribute(ALERT_SUCCESS, true);
    }
}
