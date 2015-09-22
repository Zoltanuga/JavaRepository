package by.autoServiceStation.service;

import by.autoServiceStation.database.dao.impl.OrderDaoImpl;
import by.autoServiceStation.entities.Order;

import java.util.List;

public class OrdersService {
    private OrderDaoImpl orderDAO = new OrderDaoImpl();

    public boolean addOrder(Order order) {
        return orderDAO.addOrder(order);
    }

    public List<Order> obtainOrders() {
        return orderDAO.obtainOrders();
    }

    public boolean updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    public boolean deleteOrder(int orderId) {
        return orderDAO.deleteOrder(orderId);
    }
}
