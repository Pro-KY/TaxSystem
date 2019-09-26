package ua.training.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.command.CommandFactory;
import ua.training.command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(FrontController.class);

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

        if (page == null) {
            response.sendRedirect("/error.jsp");
            return;
        }

        final Object language = request.getSession().getAttribute("language");
        System.out.println("language: " + language);

        if(page.equals("/index.jsp")) {
            response.sendRedirect("/");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
