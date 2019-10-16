package dao;

import entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDAO {
    List<Order> selectOrderByUserId(@Param("id") Integer id);
    void insertOrder(@Param("order") Order order);
    //修改订单状态
    void updateOrderByOrderId(@Param("id") Integer id);
}
