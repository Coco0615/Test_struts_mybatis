package dao;

import entity.Item;
import org.apache.ibatis.annotations.Param;

public interface ItemDAO {
    void insertItem(@Param("item") Item item);
    //根据订单号删除订单详情

}
