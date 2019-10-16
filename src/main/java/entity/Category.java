package entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private Integer category_id;
    private String category_name;
    private Integer parent_id;
    private Integer book_count;
    private List<Category> categories;

    public Category() {
    }

    public Category(Integer category_id, String category_name, Integer parent_id, Integer book_count, List<Category> categories) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.parent_id = parent_id;
        this.book_count = book_count;
        this.categories = categories;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getBook_count() {
        return book_count;
    }

    public void setBook_count(Integer book_count) {
        this.book_count = book_count;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", parent_id=" + parent_id +
                ", book_count=" + book_count +
                ", categories=" + categories +
                '}';
    }
}
