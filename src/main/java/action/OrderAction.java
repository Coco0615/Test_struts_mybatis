package action;

import entity.Address;
import entity.Cart;
import entity.Order;
import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.AddressServiceImpl;
import service.impl.CartServiceImpl;
import service.impl.OrderServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderAction {
    private List<Cart> carts;
    private double sum;
    private List<Address> addresses;
    private List<Order> orders;
    private Integer address;
    private Order order;
    //支付宝返回的订单号
    private Integer out_trade_no;
    //确认订单
    public String verifyOrder(){
        CartServiceImpl cs = new CartServiceImpl();
        User user =(User) ServletActionContext.getRequest().getSession().getAttribute("user");
        carts = cs.selectCartByUserId(user.getUser_id());

        for (Cart cart: carts) {
            sum += cart.getBuy_count()*cart.getBook().getDang_price();
        }
        return "order_infoJSP";
    }
    //通过用户id查询地址
    public String getAddress(){
        User user =(User) ServletActionContext.getRequest().getSession().getAttribute("user");
        AddressServiceImpl as = new AddressServiceImpl();
        addresses = as.selectAddressByUserId(user.getUser_id());
        return "address_formJSP";
    }
    public String selectOrderByUserId(){
        User user =(User) ServletActionContext.getRequest().getSession().getAttribute("user");
        OrderServiceImpl os = new OrderServiceImpl();
        orders = os.selectOrderByUserId(user.getUser_id());
        return "my_orderJSP";

    }
    public String insertOrder(){
        CartServiceImpl cs = new CartServiceImpl();
        User user =(User) ServletActionContext.getRequest().getSession().getAttribute("user");
        carts = cs.selectCartByUserId(user.getUser_id());
        for (Cart cart: carts) {
            sum += cart.getBuy_count()*cart.getBook().getDang_price();
        }
        order = new Order(null, null, user.getUser_id(), sum, address, null, null);
        OrderServiceImpl os = new OrderServiceImpl();
        os.insertOrder(order);
        return "order_okJSP";
    }
    //修改账户状态
    public String updateOrderByOrderId(){
        OrderServiceImpl os = new OrderServiceImpl();
        os.updateOrderByOrderId(out_trade_no);
        return "selectOrderByUserId";
    }
    //get/set

    public Integer getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(Integer out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
