package by.autoServiceStation.database.dao;

import by.autoServiceStation.entities.Car;

import java.util.List;

public interface CarDao {
    boolean addCar(Car car);
    boolean deleteCar(String vin);
    boolean updateCar(Car car);
    Car obtainCar(String vin);
    List<Car> obtainCars();
}
