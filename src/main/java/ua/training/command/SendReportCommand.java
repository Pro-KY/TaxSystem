package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.util.CommandHelper;
import ua.training.command.util.CommandParamsExtractor;
import ua.training.dto.SendReportDto;
import ua.training.persistence.entities.User;
import ua.training.service.SendReportService;
import ua.training.util.constans.Attributes;
import ua.training.util.exceptions.ServiceException;
import ua.training.util.handler.properties.ViewPropertiesHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

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

            final CommandParamsExtractor paramsExtractor = CommandParamsExtractor.getInstance();
            final Optional<SendReportDto> reportOptional = paramsExtractor.extractParamsIntoBean(request, SendReportDto.class);

            try {
                if (reportOptional.isPresent()) {
                    final SendReportDto sendReportDto = reportOptional.get();
                    sendReportDto.setUser(user);
                    sendReportService.saveSentReport(sendReportDto);
                    CommandHelper.setSendReportCommandAttributes(request);
                    page = ViewPropertiesHandler.getViewPath(PATH_MAIN);
                } else {
                    page = CommandHelper.getErrorPage(request, "err_msg");
                }
            } catch (ServiceException e) {
                page = CommandHelper.getErrorPage(request, "err_msg");
            }
        } else {
            page = ViewPropertiesHandler.getViewPath(PATH_INDEX);
        }

        return page;
    }
}
