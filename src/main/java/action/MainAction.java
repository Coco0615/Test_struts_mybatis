package action;

import entity.Book;
import entity.Category;
import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MainAction {
    private List<Category> cs;
    private List<Book> editorbooks;
    private List<Book> salebooks;
    private List<Book> newbooks;
    private List<Book> newandsalebooks;
    private User user;


    public String selectAllInMain(){
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession se = req.getSession();
        user =(User) se.getAttribute("user");
        //展示左侧图书类型
        CategoryServiceImpl csi = new CategoryServiceImpl();
        cs = csi.selectAllCategorys();
        //展示编辑推荐的2本图书
        BookServiceImpl bs = new BookServiceImpl();
        editorbooks = bs.selectEditorRecommendBooks();
        //展示销量最多的8本图书
        salebooks = bs.selectSaleCountMaxBooks();
        //展示最新上架的8本图书
        newbooks = bs.selectNewArrivalBooks();
        //展示最新热卖的8本图书
        newandsalebooks  = bs.selectNewAndSaleMaxBooks();
        //登录人

        return "mainJSP";
    }


    //set/get


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getNewandsalebooks() {
        return newandsalebooks;
    }

    public void setNewandsalebooks(List<Book> newandsalebooks) {
        this.newandsalebooks = newandsalebooks;
    }

    public List<Book> getNewbooks() {
        return newbooks;
    }

    public void setNewbooks(List<Book> newbooks) {
        this.newbooks = newbooks;
    }

    public List<Book> getEditorbooks() {
        return editorbooks;
    }

    public void setEditorbooks(List<Book> editorbooks) {
        this.editorbooks = editorbooks;
    }

    public List<Book> getSalebooks() {
        return salebooks;
    }

    public void setSalebooks(List<Book> salebooks) {
        this.salebooks = salebooks;
    }

    public List<Category> getCs() {
        return cs;
    }

    public void setCs(List<Category> cs) {
        this.cs = cs;
    }
}
