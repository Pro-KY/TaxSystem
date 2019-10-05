package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.constans.Parameters;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class InspectorChangingCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(InspectorChangingCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Long inspectorId = Long.valueOf(request.getParameter(Parameters.INSPECTOR_ID));
        Long reportApprovalId = Long.valueOf(request.getParameter(Parameters.REPORT_APPROVAL_ID));

        log.info("InspectorChangingCommand executed");
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);

        // save in change_inspector
        // get randomly new inspector
        // update report_approval
    }
}

