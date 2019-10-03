package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.persistence.entities.User;
import ua.training.service.SignUpService;
import ua.training.util.constans.Attributes;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.MessagePropertiesHandler;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;

import static ua.training.util.handler.properties.MessagePropertiesHandler.ERROR_PARSING;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_ERROR;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_INDEX;

public class SignUpCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SignUpCommand.class);


    @Override
    public String execute(HttpServletRequest request) {
        final CommandParametersExtractor paramsExtractor = CommandParametersExtractor.getInstance();
        final User user = paramsExtractor.extractParameters(request, User.class);

        final SignUpService signUpService = SignUpService.getInstance();

        String page;

        try {
            if (user != null) {
//                signUpService.saveSignedUpUser(userOptional.get());
                signUpService.saveSignedUpUser(user);
                page = ViewPropertiesHandler.getViewPath(PATH_INDEX);
                request.getSession().setAttribute(Attributes.IS_SIGN_UP, false);
            } else {
                request.getSession().removeAttribute(Attributes.IS_SIGN_UP);
                request.setAttribute("errorMsg", MessagePropertiesHandler.getMessage(ERROR_PARSING));
                page = ViewPropertiesHandler.getViewPath(PATH_ERROR);
            }
        } catch (ServiceException e){
            request.setAttribute("errorMsg", MessagePropertiesHandler.getMessage(ERROR_PARSING));
            page = ViewPropertiesHandler.getViewPath(PATH_ERROR);
        }

        return page;
    }
}
