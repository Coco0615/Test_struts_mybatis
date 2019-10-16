package action;

import entity.Book;
import entity.Cart;
import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.BookServiceImpl;
import service.impl.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CartAction {
    private List<Cart> carts;
    private List<Cart> deleteCarts;
    private double sumPrice;
    private double sumBookPrice;
    private double chajia;
    private Integer count;
    private Integer cart_id;
    private Integer book_id;

    //根据用户名id查询购物车
    public String selectCartByUserId(){
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession se = req.getSession();
        User user = (User)se.getAttribute("user");
        CartServiceImpl cs = new CartServiceImpl();
        if(user==null){
            return "login";
        }
        carts = cs.selectCartByUserId(user.getUser_id());
        if(carts!=null){
            for (Cart cart:carts) {
                    Integer buy_count = cart.getBuy_count();
                    Double dang_price = cart.getBook().getDang_price();
                    Double book_price = cart.getBook().getBook_price();
                    sumPrice += buy_count*dang_price;
                    sumBookPrice += buy_count*book_price;
            }
        }
        chajia = sumBookPrice-sumPrice;
        //System.out.println("sumPrice = " + sumPrice);
        deleteCarts = cs.selectCartAfterDeleteByUserId(user.getUser_id());
        return "cartListJSP";
    }
    //根据cart的id变更商品图书的数量number
    public String updateBuyCountByCartId(){
        CartServiceImpl cs = new CartServiceImpl();
        //System.out.println("cid="+cart_id+"ct="+count);
        cs.updateBuyCountByCartId(cart_id,count);
        return "selectCartByUserId";
    }

    //恢复删除
    public String undelete(){
        CartServiceImpl cs = new CartServiceImpl();
        cs.updateCartDeleteState(cart_id);
        return "selectCartByUserId";
    }
    //点击购买
    public String buy(){
        CartServiceImpl cs = new CartServiceImpl();
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession se = req.getSession();
        User user = (User)se.getAttribute("user");
        Cart cart = new Cart(null, book_id, user.getUser_id(), 1, 0, null, null);
        System.out.println("cart = " + cart);
        cs.buy(cart);
        return null;
    }
    //点击删除
    public String deleteCartById(){
        CartServiceImpl cs = new CartServiceImpl();
        cs.deleteCartById(cart_id);
        return "selectCartByUserId";
    }


    //set/get


    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public List<Cart> getDeleteCarts() {
        return deleteCarts;
    }

    public void setDeleteCarts(List<Cart> deleteCarts) {
        this.deleteCarts = deleteCarts;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public double getSumBookPrice() {
        return sumBookPrice;
    }

    public void setSumBookPrice(double sumBookPrice) {
        this.sumBookPrice = sumBookPrice;
    }

    public double getChajia() {
        return chajia;
    }

    public void setChajia(double chajia) {
        this.chajia = chajia;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
