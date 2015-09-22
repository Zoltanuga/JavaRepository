package by.autoServiceStation.navigation.impl;

import by.autoServiceStation.entities.Client;
import by.autoServiceStation.navigation.Command;
import by.autoServiceStation.service.ClientsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static by.autoServiceStation.resources.constants.Constants.CONTROLLER_COMMAND_MAIN_REDIRECT;
import static by.autoServiceStation.resources.constants.Constants.MAIN_PAGE;


public class AddClientCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ClientsService clientsService = new ClientsService();
        Client client = new Client();
        initClient(request, client);
        boolean isSuccessfulAdd = clientsService.addClient(client);
        HttpSession session = request.getSession();
        if (isSuccessfulAdd) {
            session.setAttribute("currentClient", client);
        }
        try {
            response.sendRedirect(CONTROLLER_COMMAND_MAIN_REDIRECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MAIN_PAGE;
    }

    private void initClient(HttpServletRequest request, Client client) {
        client.setFirstName(request.getParameter("clientFirstNameInput"));
        client.setLastName(request.getParameter("clientLastNameInput"));
        String dateString = request.getParameter("clientDateOfBirthInput");
        client.setDateOfBirth(convertToCalendar(dateString));
        client.setPhone(request.getParameter("clientPhoneInput"));
        client.setAddress(request.getParameter("clientAddressInput"));
        client.setEmail(request.getParameter("clientEmailInput"));
    }

    private Calendar convertToCalendar(String dateString) {
        int year = Integer.parseInt(dateString.substring(0, 4));
        int month = Integer.parseInt(dateString.substring(4, 6));
        int day = Integer.parseInt(dateString.substring(6, 8));
        return new GregorianCalendar(year, month, day);
    }
}
