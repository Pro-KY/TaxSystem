package ua.training.controller;
import ua.training.command.CommandFactory;
import ua.training.command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        handleRequest(req, resp);
    }

    private void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ICommand command = CommandFactory.getCommand(request);
        final String page = command.execute(request);
        System.out.println(page);

        if(page.equals("/index.jsp")) {
            response.sendRedirect("/");
        } else {
            RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }

    }
}
