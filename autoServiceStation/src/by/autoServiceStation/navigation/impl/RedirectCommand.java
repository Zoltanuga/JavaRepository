package by.autoServiceStation.navigation.impl;

import by.autoServiceStation.entities.Car;
import by.autoServiceStation.entities.Client;
import by.autoServiceStation.navigation.Command;
import by.autoServiceStation.service.CarsService;
import by.autoServiceStation.service.ClientsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static by.autoServiceStation.resources.constants.Constants.SHOW_CLIENT_CARD_CARS_PAGE;

public class RedirectCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Client enteredClient = (Client) session.getAttribute("currentClient");
        ClientsService clientsService = new ClientsService();
        Client client = clientsService.obtainClient(enteredClient.getFirstName(), enteredClient.getLastName());
        CarsService carsService = new CarsService();
        List<Car> cars = carsService.obtainCars();
        List<Car> clientCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getClientId() == client.getClientId()) {
                clientCars.add(car);
            }
        }
        session.setAttribute("currentClientCars", clientCars);
        return SHOW_CLIENT_CARD_CARS_PAGE;
    }
}
