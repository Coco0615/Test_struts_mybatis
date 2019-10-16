package service.impl;

import dao.BookDAO;
import dao.CommentDAO;
import entity.Book;
import entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import service.BookService;
import service.CommentService;
import util.MyBatisUtils;

import java.util.List;

public class CommentServiceImpl implements CommentService {
   //添加评论（user_id，book_id，txt）


    @Override
    public void insertContent(Integer book_id, Integer user_id, String txt) {
        SqlSession ss = MyBatisUtils.openSession();
        CommentDAO cdao = ss.getMapper(CommentDAO.class);
        cdao.insertComment(book_id,user_id,txt);
        ss.commit();
        MyBatisUtils.close(ss);
    }
    //根据book_id查询评论

    @Override
    public List<Comment> selecyCommentByBookId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CommentDAO cdao = ss.getMapper(CommentDAO.class);
        List<Comment> comments = cdao.selecyCommentByBookId(id);
        MyBatisUtils.close(ss);
        return comments;
    }
    //根据comment_id删除评论

    @Override
    public void deleteCommentByCommentId(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CommentDAO cdao = ss.getMapper(CommentDAO.class);
        cdao.deleteCommentByCommentId(id);
        ss.commit();
        MyBatisUtils.close(ss);
    }
}
