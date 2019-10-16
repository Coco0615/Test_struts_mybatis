package service.impl;

import dao.AddressDAO;
import dao.UserDAO;
import entity.Address;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;
import service.AddressService;
import service.UserService;
import util.MyBatisUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    //根据用户id查询收货地址

    @Override
    public List<Address> selectAddressByUserId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        AddressDAO adao = ss.getMapper(AddressDAO.class);
        List<Address> addresses = adao.selectAddressByUserId(id);
        MyBatisUtils.close(ss);
        return addresses;
    }
    //添加地址

    @Override
    public void insertAddress(Address address) {
        SqlSession ss = MyBatisUtils.openSession();
        AddressDAO adao = ss.getMapper(AddressDAO.class);
        adao.updateAddressNotDefaultByUserId(address.getUser_id());
        adao.insertAddress(address);
        ss.commit();
        MyBatisUtils.close(ss);
    }
    //设置默认地址
    @Override
    public void updateAddressById(Integer id) {
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession se = req.getSession();
        User u =(User) se.getAttribute("user");
        SqlSession ss = MyBatisUtils.openSession();
        AddressDAO adao = ss.getMapper(AddressDAO.class);
        adao.updateAddressNotDefaultByUserId(u.getUser_id());
        adao.updateAddressById(id);
        ss.commit();
        MyBatisUtils.close(ss);
    }
    //根据地址id删除地址

    @Override
    public void deleteAddressById(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        AddressDAO adao = ss.getMapper(AddressDAO.class);
        adao.deleteAddressById(id);
        ss.commit();
        MyBatisUtils.close(ss);
    }
}
