package by.autoServiceStation.controller;

import by.autoServiceStation.navigation.Command;
import by.autoServiceStation.navigation.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.autoServiceStation.resources.constants.Constants.PARAM_COMMAND;

public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performAction(request, response);

    }

    private void performAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentCommand = request.getParameter(PARAM_COMMAND);
        Command command = CommandFactory.getCommand(currentCommand.toUpperCase());
        String nextPage = command.execute(request, response);
        if (!response.isCommitted()) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
            requestDispatcher.forward(request, response);
        }
    }
}
