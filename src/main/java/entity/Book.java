package entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private Integer book_id;
    private String book_name;
    private String author;
    private String description;
    private Double book_price;
    private Double dang_price;
    private Integer editorRecommend;
    private Integer saleCount;
    private Date publishTime;
    private String book_img;
    private Integer category_id;

    public Book() {
    }

    public Book(Integer book_id, String book_name, String author, String description, Double book_price, Double dang_price, Integer editorRecommend, Integer saleCount, Date publishTime, String book_img, Integer category_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.description = description;
        this.book_price = book_price;
        this.dang_price = dang_price;
        this.editorRecommend = editorRecommend;
        this.saleCount = saleCount;
        this.publishTime = publishTime;
        this.book_img = book_img;
        this.category_id = category_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public Double getDang_price() {
        return dang_price;
    }

    public void setDang_price(Double dang_price) {
        this.dang_price = dang_price;
    }

    public Integer getEditorRecommend() {
        return editorRecommend;
    }

    public void setEditorRecommend(Integer editorRecommend) {
        this.editorRecommend = editorRecommend;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", book_price=" + book_price +
                ", dang_price=" + dang_price +
                ", editorRecommend=" + editorRecommend +
                ", saleCount=" + saleCount +
                ", publishTime=" + publishTime +
                ", book_img='" + book_img + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
