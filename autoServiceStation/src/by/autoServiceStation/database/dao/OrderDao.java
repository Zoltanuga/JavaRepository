package by.autoServiceStation.database.dao;


import by.autoServiceStation.entities.Order;

import java.util.List;

public interface OrderDao {
    boolean addOrder(Order order);
    boolean deleteOrder(int orderId);
    boolean updateOrder(Order order);
    Order obtainOrder(int orderId);
    List<Order> obtainOrders();
}
