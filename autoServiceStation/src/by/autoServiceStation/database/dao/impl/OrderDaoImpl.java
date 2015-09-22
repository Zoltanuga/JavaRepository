package by.autoServiceStation.database.dao.impl;

import by.autoServiceStation.database.ConnectionPool;
import by.autoServiceStation.database.dao.OrderDao;
import by.autoServiceStation.entities.Order;
import by.autoServiceStation.entities.OrderStatusEnum;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OrderDaoImpl implements OrderDao {
    private ResourceBundle queries = ResourceBundle.getBundle("by.autoServiceStation.resources.DatabaseResources");

    @Override
    public boolean addOrder(Order order) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlInsertOrder"));
            initializePrepareStatement(order, prStatement);
            prStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlDeleteOrder"));
            prStatement.setInt(1, orderId);
            prStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean isSuccess = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement prStatement = connection.prepareStatement(queries.getString("sqlUpdateOrder"));
            // initializePrepareStatement(order, prStatement);
            prStatement.setDate(1, convertToSqlDate(order.getDate()));
            prStatement.setFloat(2, order.getOrderAmount());
            prStatement.setObject(3, order.getOrderStatus().toString());
            prStatement.setInt(4, order.getOrderId());
            List<Integer> existingOrderId = obtainOrderIdList();
            if (existingOrderId.contains(order.getOrderId())) {
                prStatement.executeUpdate();
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public Order obtainOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> obtainOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqlSelectOrders"));
            orders = initOrders(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private void initializePrepareStatement(Order order, PreparedStatement prStatement) throws SQLException {
        prStatement.setDate(1, convertToSqlDate(order.getDate()));
        prStatement.setFloat(2, order.getOrderAmount());
        prStatement.setObject(3, order.getOrderStatus().toString());
        prStatement.setString(4, order.getVin());
    }

    private Date convertToSqlDate(Calendar calendar) {
        return new Date(calendar.getTime().getTime());
    }

    private List<Integer> obtainOrderIdList() {
        List<Integer> orderIdList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(queries.getString("sqlSelectAllOrderId"));
            while (result.next()) {
                orderIdList.add(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderIdList;
    }

    private List<Order> initOrders(ResultSet result) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (result.next()) {
            Order order = new Order();
            order.setOrderId(result.getInt("ORDER_ID"));
            Calendar date = convertToCalendar(result.getDate("DATE"));
            order.setDate(date);
            order.setOrderAmount(result.getFloat("ORDER_AMOUNT"));
            order.setOrderStatus(OrderStatusEnum.valueOf(result.getObject("ORDER_STATUS").toString()));
            order.setVin(result.getString("VIN"));
            orders.add(order);
        }
        return orders;
    }

    private Calendar convertToCalendar(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
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
}
