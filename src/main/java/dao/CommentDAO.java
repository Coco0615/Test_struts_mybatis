package dao;

import entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDAO {
    //根据book_id和user_id添加评论
    void insertComment(@Param("book_id") Integer book_id,@Param("user_id") Integer user_id,@Param("txt") String txt);
    //根据book_id查询评论
    List<Comment> selecyCommentByBookId(@Param("id") Integer id);
    /*//根据user_id查询评论
    List<Comment> selecyCommentByUserId(@Param("id") Integer id);*/
    //根据comment_id删除评论
    void deleteCommentByCommentId(@Param("id") Integer id);
}
