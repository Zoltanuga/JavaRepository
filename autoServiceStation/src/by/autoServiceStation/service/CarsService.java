package by.autoServiceStation.service;


import by.autoServiceStation.database.dao.impl.CarDaoImpl;
import by.autoServiceStation.entities.Car;

import java.util.List;

public class CarsService {
    private CarDaoImpl carDAO = new CarDaoImpl();

    public boolean addCar(Car car) {
        return carDAO.addCar(car);
    }

    public List<Car> obtainCars() {
        return carDAO.obtainCars();
    }

    public boolean updateCar(Car car) {
        return carDAO.updateCar(car);
    }

    public boolean deleteCar(String vin) {
        return carDAO.deleteCar(vin);
    }

}
