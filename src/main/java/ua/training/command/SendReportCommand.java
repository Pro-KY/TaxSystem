package ua.training.command;

import ua.training.persistance.beans.Report;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class SendReportCommand implements ICommand {




    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Im here");

        final Optional<Report> reportBean = CommandParamsExtractor.extractParamsIntoBean(CommandUtilFunctions.extractParamsIntoReport, request);
        final Optional<Report> apply = CommandUtilFunctions.extractParamsIntoReport.apply(request);

        apply.ifPresent(report -> {
            System.out.println(report.toString());
        });

        return null;
    }
}
