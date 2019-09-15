package ua.training.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class CommandFactory {
    private static HashMap<String, ICommand> commandHashMap = new HashMap<>(); // key - attribute from request, getValue = ICommand

    static {
        System.out.println("init called");
        commandHashMap.put("login", new AuthorizationCommand());
        commandHashMap.put("logout", new LogoutCommand());
    }

    public static ICommand getCommand(HttpServletRequest request) {
        ICommand command;
        final String cliendCommand = request.getParameter("command");
        System.out.println(cliendCommand);

        if (cliendCommand == null || cliendCommand.isEmpty()) {
            command = new EmptyCommand();
        } else {
            command = commandHashMap.get(cliendCommand);
        }

        return command;
    }
}
