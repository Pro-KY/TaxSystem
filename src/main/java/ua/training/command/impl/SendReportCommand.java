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
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_INDEX;
import static ua.training.util.handler.properties.ViewPropertiesHandler.PATH_MAIN;

public class SendReportCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SendReportCommand.class);
    private SendReportService sendReportService;

    public SendReportCommand() {
        this.sendReportService = new SendReportService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        String page;

        if(session != null) {
            final User user = (User) session.getAttribute(Attributes.USER);

            final CommandParametersExtractor paramsExtractor = CommandParametersExtractor.getInstance();
            final SendReportDto sendReportDto = paramsExtractor.extractParameters(request, SendReportDto.class);

            try {
                if (sendReportDto != null) {
                    sendReportDto.setUser(user);
                    sendReportService.saveSentReport(sendReportDto);
                    CommandAttributesSetter.setSendReportCommandAttributes(request);
                    page = ViewPropertiesHandler.getViewPath(PATH_MAIN);
                } else {
                    page = CommandAttributesSetter.getErrorPage(request, "err_msg");
                }
            } catch (ServiceException e) {
                page = CommandAttributesSetter.getErrorPage(request, "err_msg");
            }
        } else {
            page = ViewPropertiesHandler.getViewPath(PATH_INDEX);
        }

        return page;
    }
}
