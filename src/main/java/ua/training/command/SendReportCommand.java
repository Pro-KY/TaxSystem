package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.util.CommandParamsExtractor;
import ua.training.dto.SendReportDto;
import ua.training.persistance.beans.User;
import ua.training.service.SendReportService;
import ua.training.util.constans.Attributes;
import ua.training.util.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

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

        final Optional<SendReportDto> reportOptional = CommandParamsExtractor.extractParamsIntoBean(request, SendReportDto.class);

        try {
            if (reportOptional.isPresent()) {
                final SendReportDto sendReportDto = reportOptional.get();
                sendReportDto.setUser(user);
                sendReportService.saveSentReport(sendReportDto);
            } else {
                // show error page
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            // return error page
        }

        return null;
    }
}
