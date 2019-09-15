package ua.training.command;

import ua.training.persistance.beans.User;
import ua.training.persistance.util.Param;
import ua.training.service.AuthorizationService;
import ua.training.util.PropertiesHandler;
import ua.training.util.handler.properties.MessageProperty;
import ua.training.util.handler.properties.ViewProperty;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static ua.training.util.handler.properties.MessageProperty.LOGIN_ERROR;
import static ua.training.util.handler.properties.ViewProperty.*;

public class LogoutCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return ViewProperty.getViewPath(PATH_INDEX);
    }
}
