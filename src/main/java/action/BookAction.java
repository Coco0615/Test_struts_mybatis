package action;

import entity.Book;
import entity.Comment;
import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.BookServiceImpl;
import service.impl.CommentServiceImpl;

import java.util.List;

public class BookAction {
    private Integer book_id;
    private Book book;
    private List<Comment> comments;
    private User user;
    public String selectBookById(){
        BookServiceImpl bs = new BookServiceImpl();
        CommentServiceImpl cs = new CommentServiceImpl();
        user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");

        comments = cs.selecyCommentByBookId(book_id);
        book = bs.selectBookById(book_id);
        return "showBook";

    }
    public String selectBookByIdComment(){
        BookServiceImpl bs = new BookServiceImpl();
        CommentServiceImpl cs = new CommentServiceImpl();
        user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
        Integer book_id1 = (Integer)ServletActionContext.getRequest().getSession().getAttribute("book_id1");
        comments = cs.selecyCommentByBookId(book_id1);
        book = bs.selectBookById(book_id1);
        return "showBook";

    }


    //set/get


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {

        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
}
