package ua.training.command;

import ua.training.command.fragments.ReportFragmentCommand;
import ua.training.util.constans.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


public class CommandFactory {
    private static HashMap<String, ICommand> commandHashMap = new HashMap<>(); // key - parameter from request, getValue = ICommand

    static {
        commandHashMap.put(Command.SIGN_IN, new SignInCommand());
        commandHashMap.put(Command.SIGN_OUT, new SignOutCommand());
        commandHashMap.put(Command.CHANGE_LANGUAGE, new LanguageCommand());
        commandHashMap.put(Command.SEND_REPORT, new SendReportCommand());
        commandHashMap.put(Command.PROCESS_REPORT, new ProcessReportCommand());
        commandHashMap.put(Command.GET_REPORT_FRAGMENT, new ReportFragmentCommand());
    }

    public static ICommand getCommand(HttpServletRequest request) {
        ICommand command;
        final String cliendCommand = request.getParameter("command");
        System.out.println("command: " + cliendCommand);

        if (cliendCommand == null || cliendCommand.isEmpty()) {
            command = new EmptyCommand();
        } else {
            command = commandHashMap.get(cliendCommand);
        }

        return command;
    }
}
