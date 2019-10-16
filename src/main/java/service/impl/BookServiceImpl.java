package service.impl;

import dao.BookDAO;
import entity.Book;
import org.apache.ibatis.session.SqlSession;
import service.BookService;
import util.MyBatisUtils;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    //编辑推荐的图书
    public List<Book> selectEditorRecommendBooks() {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectEditorRecommendBooks();
        MyBatisUtils.close(ss);
        return books;
    }
    //销量最多的图书
    @Override
    public List<Book> selectSaleCountMaxBooks() {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectSaleCountMaxBooks();
        MyBatisUtils.close(ss);
        return books;
    }
    //最新上架
    @Override
    public List<Book> selectNewArrivalBooks() {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectNewArrivalBooks();
        MyBatisUtils.close(ss);
        return books;
    }
    //最新热卖
    @Override
    public List<Book> selectNewAndSaleMaxBooks() {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectNewAndSaleMaxBooks();
        MyBatisUtils.close(ss);
        return books;

    }
    //根据书籍id查询
    @Override
    public Book selectBookById(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        Book book = bdao.selectBookById(id);
        MyBatisUtils.close(ss);
        return book;
    }
    //根据小说类型的一级编号查询到的图书
    @Override
    public List<Book> selectAllBooksByFirst(Integer id,Integer page,Integer rows) {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectAllBooksByFirst(id,page,rows);
        MyBatisUtils.close(ss);
        return books;

    }
    //根据小说类型的二级编号查询到的图书
    @Override
    public List<Book> selectAllBooksBySecond(Integer id,Integer page,Integer rows) {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectAllBooksBySecond(id,page,rows);
        MyBatisUtils.close(ss);
        return books;
    }
    //根据一级目录查询图书的个数
    @Override
    public Integer countFirst(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        Integer count = bdao.countFirst(id);
        MyBatisUtils.close(ss);
        return count;
    }
     //根据二级目录查询图书的个数
    @Override
    public Integer countSecond(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        Integer count = bdao.countSecond(id);
        MyBatisUtils.close(ss);
        return count;
    }

}
