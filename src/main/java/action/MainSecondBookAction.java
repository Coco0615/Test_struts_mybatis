package action;

import entity.Category;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

import entity.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainSecondBookAction {
    private Integer category_id;
    private String categoryName;
    private Category category;
    private List<Book> firstBooks;
    private Integer page=1;
    private Integer rows=3;
    private Integer pageMax;

    //根据一级书籍类型id查询到的页面
    public String selectAllByFirstInSecondMain(){
        //展示左侧图书类型
        CategoryServiceImpl cs = new CategoryServiceImpl();
        category = cs.selectCategoryByFirst(category_id);
        BookServiceImpl bs = new BookServiceImpl();
        firstBooks = bs.selectAllBooksByFirst(category_id,page,rows);
        Integer count = bs.countFirst(category_id);
        pageMax = count%rows==0?count/rows:count/rows+1;
        return "bookListJSP";
    }
     //根据二级书籍类型id查询到的页面
    public String selectAllBySecondInSecondMain(){
        //展示左侧图书类型
        CategoryServiceImpl cs = new CategoryServiceImpl();
        category = cs.selectCategoryBySecond(category_id);
        BookServiceImpl bs = new BookServiceImpl();
        firstBooks = bs.selectAllBooksBySecond(category_id,page,rows);
        categoryName = cs.selectCategoryNameById(category_id);
        Integer count = bs.countSecond(category_id);
        pageMax = count%rows==0?count/rows:count/rows+1;
        return "bookListJSP";
    }

    //set/get




    public Integer getPageMax() {
        return pageMax;
    }

    public void setPageMax(Integer pageMax) {
        this.pageMax = pageMax;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getFirstBooks() {
        return firstBooks;
    }

    public void setFirstBooks(List<Book> firstBooks) {
        this.firstBooks = firstBooks;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
