package ua.training.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.fragments.ReportFragmentCommand;
import ua.training.command.fragments.SignInFragmentCommand;
import ua.training.command.fragments.SignUpFragmentCommand;
import ua.training.command.impl.*;
import ua.training.util.constans.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


public class CommandFactory {
    private static final Logger log = LogManager.getLogger(CommandFactory.class);

    private static HashMap<String, ICommand> commandHashMap = new HashMap<>();

    static {
        commandHashMap.put(Command.SIGN_IN, new SignInCommand());
        commandHashMap.put(Command.SIGN_OUT, new SignOutCommand());
        commandHashMap.put(Command.CHANGE_LANGUAGE, new LanguageCommand());
        commandHashMap.put(Command.SEND_REPORT, new SendReportCommand());
        commandHashMap.put(Command.PROCESS_REPORT, new ProcessReportCommand());
        commandHashMap.put(Command.SIGN_UP, new SignUpCommand());

        commandHashMap.put(Command.GET_REPORT_FRAGMENT, new ReportFragmentCommand());
        commandHashMap.put(Command.GET_SIGN_UP_FRAGMENT, new SignUpFragmentCommand());
        commandHashMap.put(Command.GET_SIGN_IN_FRAGMENT, new SignInFragmentCommand());
        commandHashMap.put(Command.SENT_REPORTS, new SentReportsCommand());
        commandHashMap.put(Command.REPORT_DETAILS, new ReportDetailsCommand());
        commandHashMap.put(Command.EDIT_REPORT, new EditReportCommand());
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
