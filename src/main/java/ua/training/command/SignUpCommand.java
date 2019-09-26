package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.util.CommandParamsExtractor;
import ua.training.persistance.beans.User;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_INDEX;

public class SignUpCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        final CommandParamsExtractor paramsExtractor = CommandParamsExtractor.getInstance();
        final Optional<User> userOptional = paramsExtractor.extractParamsIntoBean(request, User.class);
        userOptional.ifPresent(user -> System.out.println(user.toString()));

        return ViewPropertiesHandler.getViewPath(PATH_INDEX);
    }
}
