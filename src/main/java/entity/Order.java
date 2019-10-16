package entity;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer order_id;
    private Date order_time;
    private Integer user_id;
    private Double total_price;
    private Integer address_id;
    private Integer order_state;
    private List<Item> items;

    public Order() {
    }

    public Order(Integer order_id, Date order_time, Integer user_id, Double total_price, Integer address_id, Integer order_state, List<Item> items) {
        this.order_id = order_id;
        this.order_time = order_time;
        this.user_id = user_id;
        this.total_price = total_price;
        this.address_id = address_id;
        this.order_state = order_state;
        this.items = items;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getOrder_state() {
        return order_state;
    }

    public void setOrder_state(Integer order_state) {
        this.order_state = order_state;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_time=" + order_time +
                ", user_id=" + user_id +
                ", total_price=" + total_price +
                ", address_id=" + address_id +
                ", order_state=" + order_state +
                ", items=" + items +
                '}';
    }
}
