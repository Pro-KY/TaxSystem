package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandHelper;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class EditReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(EditReportCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("editReport command executed");
        CommandHelper.setEditReportCommandAttributes(request);
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

