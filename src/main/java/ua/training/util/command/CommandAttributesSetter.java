package ua.training.util.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.dto.DtoMapper;
import ua.training.dto.ReportDto;
import ua.training.persistence.entities.Report;
import ua.training.util.constans.Attributes;
import ua.training.util.properties.MessageProperties;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constans.Attributes.*;
import static ua.training.util.properties.MessageProperties.USER_SIGN_UP_MESSAGE;
import static ua.training.util.properties.ViewProperties.*;

public class CommandAttributesSetter {
    private static CommandAttributesSetter instance;
    private static final Logger log = LogManager.getLogger(CommandAttributesSetter.class);

    private CommandAttributesSetter() {}

    public static CommandAttributesSetter getInstance() {
        if (instance == null) {
            instance = new CommandAttributesSetter();
        }
        return instance;
    }

    public String getErrorPage(HttpServletRequest request, String msg) {
        request.setAttribute(ALERT_ERROR, true);
        return ViewProperties.getViewPath(PATH_ERROR);
    }

    public void setSendReportCommandAttributes(HttpServletRequest request, boolean isOperationSuccessful) {
        String attributeName = isOperationSuccessful ? ALERT_SUCCESS : ALERT_ERROR;
        request.setAttribute(attributeName, true);
        request.setAttribute(FRAGMENT_PATH, ViewProperties.getViewPath(FRAGMENT_PATH_SEND_REPORT));
    }

    public void setGetReportCommandAttributes(HttpServletRequest request, Report report, Long reportApprovalId) {
        final ReportDto reportDto = DtoMapper.getInstance().mapToReportDto(report);
        reportDto.setReportApprovalId(reportApprovalId);
        request.setAttribute(REPORT_DTO, reportDto);
        request.setAttribute(FRAGMENT_PATH, ViewProperties.getViewPath(FRAGMENT_PATH_EDIT_REPORT));
    }

    public void setEditReportCommandAttributes(HttpServletRequest request, ReportDto reportDto, boolean isOperationSuccessful) {
        if(isOperationSuccessful) {
            request.setAttribute(FRAGMENT_PATH, ViewProperties.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
        } else {
            request.setAttribute(REPORT_DTO, reportDto);
            request.setAttribute(FRAGMENT_PATH, ViewProperties.getViewPath(FRAGMENT_PATH_EDIT_REPORT));
        }

        String attributeName = isOperationSuccessful ? ALERT_SUCCESS : ALERT_ERROR;
        request.setAttribute(attributeName, true);
    }

    public void setInspectorChangingCommandAttributes(HttpServletRequest request) {
        request.setAttribute(FRAGMENT_PATH, ViewProperties.getViewPath(FRAGMENT_PATH_SENT_REPORTS));
        request.setAttribute(ALERT_SUCCESS, true);
    }

    public void setSignUpCommandAttributes(HttpServletRequest request) {
        request.setAttribute(ALERT_SUCCESS, true);
        request.setAttribute(Attributes.IS_SIGN_UP_FRAGMENT, false);
        request.setAttribute(Attributes.ALERT_MSG, MessageProperties.getMessage(USER_SIGN_UP_MESSAGE));
    }
}
