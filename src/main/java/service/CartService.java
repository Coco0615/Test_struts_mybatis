package service;

import entity.Cart;

import java.util.List;

public interface CartService {
   //根据用户名id查询购物车
   List<Cart> selectCartByUserId(Integer id);
   //根据cart的id变更商品图书的数量number
   void updateBuyCountByCartId(Integer id,Integer count);
   //根据用户id展示所有已经删除的订单
   List<Cart> selectCartAfterDeleteByUserId(Integer id);
   //根据cart的id更新删除状态
   void updateCartDeleteState(Integer id);
   //购买
   void buy(Cart c);
   //根据cart的id删除
   void deleteCartById(Integer id);
}
