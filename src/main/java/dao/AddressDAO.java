package dao;

import entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDAO {
    //添加地址
    void insertAddress(@Param("address") Address address);
    //根据用户id查询地址
    List<Address> selectAddressByUserId(@Param("id") Integer id);
    //根据用户id修改所有的地址全部不为默认地址
    void updateAddressNotDefaultByUserId(@Param("id") Integer id);
    //根据地址id修改当前地址为默认地址
    void updateAddressById(@Param("id") Integer id);
    //删除地址
    void deleteAddressById(@Param("id") Integer id);
}
