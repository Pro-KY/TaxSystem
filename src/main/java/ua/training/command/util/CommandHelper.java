package ua.training.command.util;

import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.constans.Attributes.*;
import static ua.training.util.handler.properties.ViewPropertiesHandler.FRAGMENT_PATH_SEND_REPORT;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_ERROR;

public class CommandHelper {
    public static String getErrorPage(HttpServletRequest request, String msg) {
        request.setAttribute(ERROR_MSG, msg);
        return ViewPropertiesHandler.getViewPath(PATH_ERROR);
    }

    public static void setSendReportCommandAttributes(HttpServletRequest request) {
        request.setAttribute(ALERT, "true");
        request.setAttribute(ALERT_MSG, ALERT_MSG_REPORT_SUCCES_KEY);
        request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SEND_REPORT));
    }
}
