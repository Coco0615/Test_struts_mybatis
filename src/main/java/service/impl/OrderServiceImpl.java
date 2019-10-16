package service.impl;

import dao.CartDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import entity.Cart;
import entity.Item;
import entity.Order;
import org.apache.ibatis.session.SqlSession;
import service.OrderService;
import util.MyBatisUtils;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> selectOrderByUserId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        OrderDAO odao = ss.getMapper(OrderDAO.class);
        List<Order> orders = odao.selectOrderByUserId(id);
        MyBatisUtils.close(ss);
        return orders;
    }

    @Override
    public void insertOrder(Order order) {
        SqlSession ss = MyBatisUtils.openSession();
        OrderDAO odao = ss.getMapper(OrderDAO.class);
        CartDAO cdao = ss.getMapper(CartDAO.class);
        ItemDAO idao = ss.getMapper(ItemDAO.class);
        odao.insertOrder(order);
        System.out.println("order = " + order);
        List<Cart> carts = cdao.selectCartByUserId(order.getUser_id());
        for (Cart cart:carts) {
            Item item = new Item(null, cart.getBook_id(), cart.getBook().getDang_price(), cart.getBuy_count(), order.getOrder_id(),null);
            idao.insertItem(item);
            cdao.chediDeleteCartById(cart.getCart_id());
        }
        ss.commit();
        MyBatisUtils.close(ss);
    }
//修改订单状态
    @Override
    public void updateOrderByOrderId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        OrderDAO odao = ss.getMapper(OrderDAO.class);
        odao.updateOrderByOrderId(id);
        ss.commit();
        MyBatisUtils.close(ss);
    }
}
