package ua.training.command;

import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_INSPECTOR_PROCESS_REPORT;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class RegistrationCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("process report command");
        request.setAttribute("fragmentPath", PATH_INSPECTOR_PROCESS_REPORT);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
