package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.command.util.CommandUtil;
import ua.training.persistence.entities.User;
import ua.training.service.SignUpService;
import ua.training.util.properties.ViewProperties;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Function;

import static ua.training.util.properties.ViewProperties.PATH_INDEX;

public class SignUpCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(SignUpCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("user is sign up");
        final CommandParametersExtractor paramsExtractor = CommandParametersExtractor.getInstance();
        final Function<HttpServletRequest, User> getUserMappingFunction = CommandUtil.getInstance().userMappingFunction;
        final User user = paramsExtractor.extractToEntity(request, getUserMappingFunction);
        final SignUpService signUpService = SignUpService.getInstance();

        signUpService.saveSignedUpUser(user);
        CommandAttributesSetter.getInstance().setSignUpCommandAttributes(request);
        return ViewProperties.getViewPath(PATH_INDEX);
    }
}
