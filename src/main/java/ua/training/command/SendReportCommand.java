package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.util.CommandParamsExtractor;
import ua.training.persistance.entities.Report;
import ua.training.persistance.entities.User;
import ua.training.service.SendReportService;
import ua.training.util.constans.Attributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import static ua.training.command.util.CommandUtilFunctions.extractParamsIntoReport;

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

        logger.info("hello");
        final Optional<Report> reportOptional = CommandParamsExtractor.extractParamsIntoBean(extractParamsIntoReport, request);
//        final Report report = reportOptional.orElseThrow(() -> new ServiceException("Can't sent report due to some problems"));

        // if type from
        // else => parse here

        if (reportOptional.isPresent()) {
            final Report report = reportOptional.get();
            sendReportService.saveSentReport(report, user);
        }

        return null;
    }
}
