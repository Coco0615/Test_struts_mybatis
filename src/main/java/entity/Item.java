package entity;

public class Item {
    private Integer item_id;
    private Integer book_id;
    private Double dang_price;
    private Integer buy_count;
    private Integer order_id;
    private Book book;

    public Item() {
    }

    public Item(Integer item_id, Integer book_id, Double dang_price, Integer buy_count, Integer order_id, Book book) {
        this.item_id = item_id;
        this.book_id = book_id;
        this.dang_price = dang_price;
        this.buy_count = buy_count;
        this.order_id = order_id;
        this.book = book;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Double getDang_price() {
        return dang_price;
    }

    public void setDang_price(Double dang_price) {
        this.dang_price = dang_price;
    }

    public Integer getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(Integer buy_count) {
        this.buy_count = buy_count;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", book_id=" + book_id +
                ", dang_price=" + dang_price +
                ", buy_count=" + buy_count +
                ", order_id=" + order_id +
                ", book=" + book +
                '}';
    }
}
