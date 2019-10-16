package entity;

import java.io.Serializable;
import java.util.Date;
import entity.Book;

public class Cart implements Serializable {
    private Integer cart_id;
    private Integer book_id;
    private Integer user_id;
    private Integer buy_count;
    private Integer delete_state;
    private Date date;
    private Book book;

    public Cart() {
    }

    public Cart(Integer cart_id, Integer book_id, Integer user_id, Integer buy_count, Integer delete_state, Date date, Book book) {
        this.cart_id = cart_id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.buy_count = buy_count;
        this.delete_state = delete_state;
        this.date = date;
        this.book = book;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(Integer buy_count) {
        this.buy_count = buy_count;
    }

    public Integer getDelete_state() {
        return delete_state;
    }

    public void setDelete_state(Integer delete_state) {
        this.delete_state = delete_state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                ", buy_count=" + buy_count +
                ", delete_state=" + delete_state +
                ", date=" + date +
                ", book=" + book +
                '}';
    }
}
