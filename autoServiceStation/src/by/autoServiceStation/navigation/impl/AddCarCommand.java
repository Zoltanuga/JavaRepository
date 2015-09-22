package by.autoServiceStation.navigation.impl;

import by.autoServiceStation.entities.Car;
import by.autoServiceStation.entities.Client;
import by.autoServiceStation.navigation.Command;
import by.autoServiceStation.service.CarsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.autoServiceStation.resources.constants.Constants.CONTROLLER_COMMAND_MAIN_REDIRECT;
import static by.autoServiceStation.resources.constants.Constants.MAIN_PAGE;


public class AddCarCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CarsService carsService = new CarsService();
        Car car = new Car();
        initCar(request, session, car);
        carsService.addCar(car);
        try {
            response.sendRedirect(CONTROLLER_COMMAND_MAIN_REDIRECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MAIN_PAGE;
    }

    private void initCar(HttpServletRequest request, HttpSession session, Car car) {
        Client currentClient = (Client) session.getAttribute("currentClient");
        car.setClientId(currentClient.getClientId());
        car.setMake(request.getParameter("carMakeInput"));
        car.setModel(request.getParameter("carModelInput"));
        car.setYear(Integer.parseInt(request.getParameter("carYearInput")));
        car.setVin(request.getParameter("carVinInput"));
    }
}
