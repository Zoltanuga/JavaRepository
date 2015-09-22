package by.autoServiceStation.entities;


import java.util.Calendar;

public class Order {
    private int orderId;
    private Calendar date;
    private float orderAmount;
    private OrderStatusEnum orderStatus;
    private String vin;

    public Order() {
    }

    public Order(int orderId, Calendar date, float orderAmount, OrderStatusEnum orderStatus, String vin) {
        this.orderId = orderId;
        this.date = date;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.vin = vin;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date.get(1) + "/" + date.get(2) + "/" + date.get(5) +
                ", orderAmount=" + orderAmount +
                ", orderStatus='" + orderStatus.toString() + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
