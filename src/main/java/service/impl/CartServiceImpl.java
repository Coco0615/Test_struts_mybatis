package service.impl;

import dao.CartDAO;
import entity.Cart;
import org.apache.ibatis.session.SqlSession;
import service.CartService;
import util.MyBatisUtils;

import java.util.List;

public class CartServiceImpl implements CartService {
    //根据用户名id查询购物车
    @Override
    public List<Cart> selectCartByUserId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CartDAO cdao = ss.getMapper(CartDAO.class);
        List<Cart> carts = cdao.selectCartByUserId(id);
        MyBatisUtils.close(ss);
        return carts;
    }
    //根据cart的id变更商品图书的数量number

    @Override
    public void updateBuyCountByCartId(Integer id, Integer count) {
        SqlSession ss = MyBatisUtils.openSession();
        CartDAO cdao = ss.getMapper(CartDAO.class);
        cdao.updateBuyCountByCartId(id, count);
        ss.commit();
        MyBatisUtils.close(ss);

    }
    //根据用户id展示所有已经删除的订单

    @Override
    public List<Cart> selectCartAfterDeleteByUserId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CartDAO cdao = ss.getMapper(CartDAO.class);
        List<Cart> carts = cdao.selectCartAfterDeleteByUserId(id);
        MyBatisUtils.close(ss);
        return carts;
    }
    //根据cart的id更新删除状态

    @Override
    public void updateCartDeleteState(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CartDAO cdao = ss.getMapper(CartDAO.class);
        Cart cart = cdao.selectDeleteCartByCartId(id);
        Cart cart2 = cdao.selectCartByBookId(cart.getBook_id());
        if(cart2==null){
            cdao.updateCartDeleteState(id);
        }else {
            Cart cart1 = cdao.selectDeleteCartByBookId(cart.getBook_id());
            cdao.updatexiangtong(cart.getBook_id(),cart1.getBuy_count());
            cdao.chediDeleteCartById(cart1.getCart_id());
        }

        ss.commit();
        MyBatisUtils.close(ss);
    }
    //购买

    @Override
    public void buy(Cart c) {
        SqlSession ss = MyBatisUtils.openSession();
        CartDAO cdao = ss.getMapper(CartDAO.class);
        Cart cart = cdao.selectCartByBookId(c.getBook_id());
        if(cart==null){
            cdao.insertCart(c);
        }else {
            cdao.updateCartBookCount(cart.getCart_id());
        }
        ss.commit();
        MyBatisUtils.close(ss);
    }
    //删除


    @Override
    public void deleteCartById(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CartDAO cdao = ss.getMapper(CartDAO.class);
        cdao.deleteCartById(id);
        ss.commit();
        MyBatisUtils.close(ss);
    }
}
