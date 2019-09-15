package ua.training.command;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
    String execute(HttpServletRequest request); // return page(path)
}
