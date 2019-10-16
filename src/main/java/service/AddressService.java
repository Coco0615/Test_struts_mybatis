package service;

import entity.Address;
import entity.User;

import java.util.List;

public interface AddressService {
   //根据用户id查询收货地址
    List<Address> selectAddressByUserId(Integer id);
    //添加地址
    void insertAddress(Address address);
    //根据地址id修改当前地址为默认地址
    void updateAddressById(Integer id);
    //根据地址id删除地址
    void deleteAddressById(Integer id);
}
