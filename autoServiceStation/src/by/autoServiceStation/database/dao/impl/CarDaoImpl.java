package by.autoServiceStation.database.dao.impl;


import by.autoServiceStation.database.ConnectionPool;
import by.autoServiceStation.database.dao.CarDao;
import by.autoServiceStation.entities.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarDaoImpl implements CarDao {
    private ResourceBundle queries = ResourceBundle.getBundle("by.autoServiceStation.resources.DatabaseResources");

    @Override
    public boolean addCar(Car car) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlInsertCar"));
            initializePrepareStatement(car, prStatement);
            prStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean deleteCar(String vin) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlDeleteCar"));
            prStatement.setString(1, vin);
            List<String> existingVinNumbers = obtainVinList();
            List<String> existingVinNumbersFromOrders = obtainVinListFromOrders();
            if (existingVinNumbers.contains(vin) && !existingVinNumbersFromOrders.contains(vin)) {
                prStatement.executeUpdate();
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean updateCar(Car car) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlUpdateCar"));
            initializePrepareStatement(car, prStatement);
            List<String> existingVinNumbers = obtainVinList();
            if (existingVinNumbers.contains(car.getVin())) {
                prStatement.executeUpdate();
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Car obtainCar(String vin) {
        return null;
    }

    @Override
    public List<Car> obtainCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqlSelectCar"));
            cars = initCars(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    private void initializePrepareStatement(Car car, PreparedStatement prStatement) throws SQLException {
        prStatement.setString(1, car.getMake());
        prStatement.setString(2, car.getModel());
        prStatement.setInt(3, car.getYear());
        prStatement.setInt(4, car.getClientId());
        prStatement.setString(5, car.getVin());
    }

    private List<String> obtainVinList() {
        List<String> vinList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqlSelectAllVinNumbers"));
            while (result.next()) {
                vinList.add(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vinList;
    }

    private List<String> obtainVinListFromOrders() {
        List<String> vinList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqlSelectAllVinNumbersFromOrders"));
            while (result.next()) {
                vinList.add(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vinList;
    }

    private List<Car> initCars(ResultSet result) throws SQLException {
        List<Car> cars = new ArrayList<>();
        while (result.next()) {
            Car car = new Car();
            car.setMake(result.getString("MAKE"));
            car.setModel(result.getString("MODEL"));
            car.setYear(result.getInt("YEAR"));
            car.setVin(result.getString("VIN"));
            car.setClientId(result.getInt("CLIENT_ID"));
            cars.add(car);
        }
        return cars;
    }
}
