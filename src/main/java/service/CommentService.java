package service;

import entity.Book;
import entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    //增加评论（user_id，book_id）
    void insertContent(Integer book_id,Integer user_id,String txt);
    //根据book_id查询评论
    List<Comment> selecyCommentByBookId(Integer id);
    //根据comment_id删除评论
    void deleteCommentByCommentId(Integer id);
}
