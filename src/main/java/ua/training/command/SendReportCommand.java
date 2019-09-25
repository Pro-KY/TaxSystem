package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.util.CommandHelper;
import ua.training.command.util.CommandParamsExtractor;
import ua.training.dto.SendReportDto;
import ua.training.persistance.beans.User;
import ua.training.service.SendReportService;
import ua.training.util.constans.Attributes;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static ua.training.util.constans.Attributes.*;
import static ua.training.util.handler.properties.ViewPropertiesHandler.*;

public class SendReportCommand implements ICommand {
    private static final Logger logger = LogManager.getLogger(SendReportCommand.class);
    private SendReportService sendReportService;

    public SendReportCommand() {
        this.sendReportService = new SendReportService();
    }

    @Override
    public String execute(HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        final User user = (User) session.getAttribute(Attributes.USER);
        String page;
        final Optional<SendReportDto> reportOptional = CommandParamsExtractor.extractParamsIntoBean(request, SendReportDto.class);

        try {
            if (reportOptional.isPresent()) {
                final SendReportDto sendReportDto = reportOptional.get();
                sendReportDto.setUser(user);
                sendReportService.saveSentReport(sendReportDto);
                request.setAttribute(ALERT, "true");
                request.setAttribute(ALERT_MSG, ALERT_MSG_REPORT_SUCCES_KEY);
                request.setAttribute(FRAGMENT_PATH, ViewPropertiesHandler.getViewPath(FRAGMENT_PATH_SEND_REPORT));
                page = ViewPropertiesHandler.getViewPath(PATH_MAIN);
            } else {
                page = CommandHelper.getErrorPage(request);
            }
        } catch (ServiceException e) {
            page = CommandHelper.getErrorPage(request);
        }

        return page;
    }
}
