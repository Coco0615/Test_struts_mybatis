package service;

import entity.Category;

import entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //编辑推荐的图书
    List<Book> selectEditorRecommendBooks();
    //销量最多的图书
    List<Book> selectSaleCountMaxBooks();
    //根据小说类型的一级编号查询到的图书
    List<Book> selectAllBooksByFirst(Integer id,Integer page,Integer rows);
    //根据小说类型的二级编号查询到的图书
    List<Book> selectAllBooksBySecond(Integer id,Integer page,Integer rows);
    //最新上架
    List<Book> selectNewArrivalBooks();
    //新书热卖
    List<Book> selectNewAndSaleMaxBooks();
    //根据书籍id查询
    Book selectBookById(Integer id);
    //根据一级目录查询图书的个数
    Integer countFirst(Integer id);
    //根据二级目录查询图书的个数
    Integer countSecond(Integer id);


}
