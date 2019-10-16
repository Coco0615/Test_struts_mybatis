package action;

import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.CommentServiceImpl;

public class CommentAction {
    private String txt;
    private Integer book_id;
    private Integer comment_id;
    //添加
    public String insertComment(){
        User user =(User) ServletActionContext.getRequest().getSession().getAttribute("user");
        CommentServiceImpl cs = new CommentServiceImpl();
        System.out.println("book_id = " + book_id);
        cs.insertContent(book_id,user.getUser_id(),txt);
        ServletActionContext.getRequest().getSession().setAttribute("book_id1",book_id);
        return "selectBookByIdComment";
    }
    //根据comment_id删除评论
    public String deleteCommentByCommentId(){
        CommentServiceImpl cs = new CommentServiceImpl();
        cs.deleteCommentByCommentId(comment_id);
        ServletActionContext.getRequest().getSession().setAttribute("book_id1",book_id);
        return "selectBookByIdComment";
    }
    //set/get

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
