package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.impl.*;
import ua.training.command.impl.fragments.ApprovingFragmentCommand;
import ua.training.command.impl.fragments.SendReportFragmentCommand;
import ua.training.command.impl.fragments.SignInFragmentCommand;
import ua.training.command.impl.fragments.SignUpFragmentCommand;
import ua.training.util.constans.Commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


public class CommandFactory {
    private static final Logger log = LogManager.getLogger(CommandFactory.class);

    private static HashMap<String, ICommand> commandHashMap = new HashMap<>();

    static {
        commandHashMap.put(Commands.SIGN_IN, new SignInCommand());
        commandHashMap.put(Commands.SIGN_OUT, new SignOutCommand());
        commandHashMap.put(Commands.CHANGE_LANGUAGE, new LanguageCommand());
        commandHashMap.put(Commands.SEND_REPORT, new SendReportCommand());
        commandHashMap.put(Commands.APPROVE_REPORT, new ApproveReportCommand());
        commandHashMap.put(Commands.SIGN_UP, new SignUpCommand());
        commandHashMap.put(Commands.GET_REPORT_FRAGMENT, new SendReportFragmentCommand());
        commandHashMap.put(Commands.GET_SIGN_UP_FRAGMENT, new SignUpFragmentCommand());
        commandHashMap.put(Commands.GET_SIGN_IN_FRAGMENT, new SignInFragmentCommand());
        commandHashMap.put(Commands.SENT_REPORTS, new SentReportsCommand());
        commandHashMap.put(Commands.REPORT_DETAILS, new ReportDetailsCommand());
        commandHashMap.put(Commands.GET_REPORT, new GetReportCommand());
        commandHashMap.put(Commands.EDIT_REPORT, new EditReportCommand());
        commandHashMap.put(Commands.CHANGE_INSPECTOR, new InspectorChangingCommand());
        commandHashMap.put(Commands.GET_UNTREATED_REPORTS, new GetUntreatedReportsCommand());
        commandHashMap.put(Commands.GET_APPROVING_FRAGMENT, new ApprovingFragmentCommand());
    }

    public static ICommand getCommand(HttpServletRequest request) {
        ICommand command;
        final String clientCommand = request.getParameter("command");
        log.info("command - {}", clientCommand);

        if (clientCommand == null || clientCommand.isEmpty() || commandHashMap.get(clientCommand) == null) {
            command = new EmptyCommand();
        } else {
            command = commandHashMap.get(clientCommand);

        }

        return command;
    }
}
