package ua.training.command;

import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

// for inspector
public class ProcessReportCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("process report command");

        final String viewPath = getViewPath(FRAGMENT_PATH_PROCESS_REPORT);
        request.setAttribute("fragmentPath", viewPath);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
