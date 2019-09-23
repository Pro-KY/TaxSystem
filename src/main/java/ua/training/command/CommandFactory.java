package ua.training.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandFactory {
    private static HashMap<String, ICommand> commandHashMap = new HashMap<>(); // key - parameter from request, getValue = ICommand

    static {
        commandHashMap.put("login", new SignInCommand()); //TODO: move all strings into properties
        commandHashMap.put("logout", new SignOutCommand());
        commandHashMap.put("changeLanguage", new LanguageCommand());
        commandHashMap.put("sendReport", new SendReportCommand());
        commandHashMap.put("processReport", new ProcessReportCommand());
        commandHashMap.put("getReportPage", new GetReportPageCommand());
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
