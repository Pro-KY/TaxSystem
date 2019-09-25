package ua.training.command.fragments;

import ua.training.command.ICommand;
import ua.training.util.constans.Attributes;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class ReportFragmentCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("ReportFragmentCommand command");

        final String viewPath = getViewPath(FRAGMENT_PATH_SEND_REPORT);
        request.setAttribute(Attributes.FRAGMENT_PATH, viewPath);
//        request.setAttribute(ALERT, true);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
