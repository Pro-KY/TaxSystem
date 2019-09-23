package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.persistance.beans.Report;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class SendReportCommand implements ICommand {

    private static final Logger log= LogManager.getLogger(SendReportCommand.class);


    @Override
    public String execute(HttpServletRequest request) {
        log.info("hello");

        final Optional<Report> reportBean = CommandParamsExtractor.extractParamsIntoBean(CommandUtilFunctions.extractParamsIntoReport, request);
        final Optional<Report> apply = CommandUtilFunctions.extractParamsIntoReport.apply(request);

        return null;
    }
}
