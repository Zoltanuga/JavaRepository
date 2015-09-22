package by.autoServiceStation.navigation.impl;

import by.autoServiceStation.entities.Administrator;
import by.autoServiceStation.navigation.Command;
import by.autoServiceStation.service.AdministratorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.autoServiceStation.resources.constants.Constants.*;

public class MainCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AdministratorService administratorService = new AdministratorService();
        List<Administrator> administrators = administratorService.obtainAdministrators();
        boolean isAdmin = false;
        for (Administrator admin : administrators) {
            boolean isRegisteredEmail = admin.getEmail().equals(request.getParameter(PARAM_EMAIL_INPUT));
            boolean isRegisteredPassword = admin.getPassword().equals(request.getParameter(PARAM_PASSWORD_INPUT));
            if (isRegisteredEmail && isRegisteredPassword) {
                isAdmin = true;
                break;
            }
        }
        if (isAdmin) {
            HttpSession session = request.getSession();
            session.setAttribute(PARAM_EMAIL_INPUT, request.getParameter(PARAM_EMAIL_INPUT));
            session.setAttribute(PARAM_PASSWORD_INPUT, request.getParameter(PARAM_PASSWORD_INPUT));
            return CHECK_CLIENT_PAGE;
        } else return MAIN_PAGE;
    }
}
