package entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer comment_id;
    private String content;
    private Date comment_time;
    private Integer user_id;
    private Integer book_id;
    private User user;

    public Comment() {
    }

    public Comment(Integer comment_id, String content, Date comment_time, Integer user_id, Integer book_id, User user) {
        this.comment_id = comment_id;
        this.content = content;
        this.comment_time = comment_time;
        this.user_id = user_id;
        this.book_id = book_id;
        this.user = user;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", comment_time=" + comment_time +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", user=" + user +
                '}';
    }
}
