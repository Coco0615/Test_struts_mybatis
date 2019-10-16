package service;

import entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    List<Order> selectOrderByUserId(Integer id);
    void insertOrder(Order order);
    //修改订单状态
    void updateOrderByOrderId(Integer id);
}
