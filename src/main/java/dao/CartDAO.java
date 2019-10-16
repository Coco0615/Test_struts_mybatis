package dao;

import entity.Cart;
import org.apache.ibatis.annotations.Param;

import entity.Book;
import java.util.List;

public interface CartDAO {
    //根据用户名id查询购物车
    List<Cart> selectCartByUserId(@Param("id") Integer id);
    //根据cart的id变更商品图书的数量number
    void updateBuyCountByCartId(@Param("id") Integer id,@Param("count") Integer count);
    //根据用户id展示所有已经删除的订单
    List<Cart> selectCartAfterDeleteByUserId(@Param("id") Integer id);
    //根据cart的id更新删除状态(恢复)
    void updateCartDeleteState(@Param("id") Integer id);
    //添加图书商品
    void insertCart(@Param("c") Cart c);
    //根据图书id查询
    Cart selectCartByBookId(@Param("id") Integer id);
    //根据cart的id修改book_count
    void updateCartBookCount(@Param("id") Integer id);
    //根据cart的id删除
    void deleteCartById(@Param("id") Integer id);
    //根据cart的id查询
    Cart selectCartByCartId(@Param("id") Integer id);
    //根据图书id查询已删除的
    Cart selectDeleteCartByBookId(@Param("id") Integer id);
    //相同图书添加
    void updatexiangtong(@Param("id") Integer id,@Param("count") Integer count);
    //根据cart的id彻底删除
    void chediDeleteCartById(@Param("id") Integer id);
    //根据cart的id查询已删除
    Cart selectDeleteCartByCartId(@Param("id") Integer id);
}
