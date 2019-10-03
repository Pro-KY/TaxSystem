package ua.training.command.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.service.ReportDetailsService;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constans.Attributes.*;
import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class CommandAttributesSetter {
    private static final Logger log = LogManager.getLogger(ReportDetailsService.class);

    public static String getErrorPage(HttpServletRequest request, String msg) {
        request.setAttribute(ERROR_MSG, msg);
        return ViewPropertiesHandler.getViewPath(PATH_ERROR);
    }

    public static void setSendReportCommandAttributes(HttpServletRequest request) {
        request.setAttribute(ALERT, "true");
        request.setAttribute(ALERT_MSG, ALERT_MSG_REPORT_SUCCES_KEY);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SEND_REPORT));
    }

    public static void setEditReportCommandAttributes(HttpServletRequest request) {
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_EDIT_REPORT));
    }
}
