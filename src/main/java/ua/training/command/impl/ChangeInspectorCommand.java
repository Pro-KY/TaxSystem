package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class ChangeInspectorCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(ChangeInspectorCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("ChangeInspectorCommand executed");
        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}

