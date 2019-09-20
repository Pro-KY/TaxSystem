package ua.training.command;

import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class SendReportCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("sendReport command");
        request.setAttribute("fragmentPath", PATH_USER_SEND_REPORT);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
