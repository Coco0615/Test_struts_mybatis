package dao;


import entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDAO {
    //编辑推荐的图书
    List<Book> selectEditorRecommendBooks();
    //销量最多的图书
    List<Book> selectSaleCountMaxBooks();
    //根据小说类型的一级编号查询到的图书
    List<Book> selectAllBooksByFirst(@Param("id") Integer id,@Param("page") Integer page,@Param("rows") Integer rows);
    //根据小说类型的二级编号查询到的图书
    List<Book> selectAllBooksBySecond(@Param("id") Integer id,@Param("page") Integer page,@Param("rows") Integer rows);
    //最新上架
    List<Book> selectNewArrivalBooks();
    //新书热卖
    List<Book> selectNewAndSaleMaxBooks();
    //根据书籍id查询
    Book selectBookById(@Param("id") Integer id);
    //根据一级目录查询图书的个数
    Integer countFirst(@Param("id") Integer id);
    //根据二级目录查询图书的个数
    Integer countSecond(@Param("id") Integer id);


}
