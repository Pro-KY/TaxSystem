package ua.training.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.ICommand;
import ua.training.command.util.CommandAttributesSetter;
import ua.training.command.util.CommandParametersExtractor;
import ua.training.dto.SendReportDto;
import ua.training.persistence.entities.User;
import ua.training.service.SendReportService;
import ua.training.util.constans.Attributes;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class SendReportCommand implements ICommand {
    private static final Logger log = LogManager.getLogger(SendReportCommand.class);
    private SendReportService sendReportService;

    public SendReportCommand() {
        this.sendReportService = new SendReportService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute(Attributes.USER);

        final CommandParametersExtractor paramsExtractor = CommandParametersExtractor.getInstance();
        final SendReportDto sendReportDto = paramsExtractor.extractParameters(request, SendReportDto.class);

        if (sendReportDto != null) {
            sendReportDto.setUser(user);
            sendReportService.saveSentReport(sendReportDto);
        }

        boolean isOperationSuccessful = sendReportDto != null;
        CommandAttributesSetter.setSendReportCommandAttributes(request, isOperationSuccessful);

        return ViewPropertiesHandler.getViewPath(PATH_MAIN);
    }
}
