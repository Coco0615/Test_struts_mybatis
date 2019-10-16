package action;

import entity.Address;
import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddressAction {
    private List<Address> addresses;
    private Address address;
    private Integer address_id;
    //根据用户id查询收货地址
    public String selectAddressByUserId(){
        AddressServiceImpl as = new AddressServiceImpl();
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession ss = req.getSession();
        User u =(User) ss.getAttribute("user");
        if(u==null){
            return "login";
        }
        addresses = as.selectAddressByUserId(u.getUser_id());
        return "myAddressJSP";
    }
    //添加地址
    public String insertAddress(){
        AddressServiceImpl as = new AddressServiceImpl();
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession ss = req.getSession();
        User u =(User) ss.getAttribute("user");
        address.setUser_id(u.getUser_id());
        as.insertAddress(address);
        return "selectAddressByUserId";
    }
    //设置默认地址
    public String updateDefaultAddress(){
        AddressServiceImpl as = new AddressServiceImpl();
        as.updateAddressById(address_id);
        return "selectAddressByUserId";
    }
    //根据地址id删除地址
    public String deleteAddressById(){
        AddressServiceImpl as = new AddressServiceImpl();
        as.deleteAddressById(address_id);
        return "selectAddressByUserId";
    }
    //set/get

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
