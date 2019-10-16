import dao.BookDAO;
import dao.CategoryDAO;
import entity.Book;
import entity.Category;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtils;

import java.util.List;

public class Test {
    @org.junit.Test
    //图书类型查询
    public void test1(){
        SqlSession ss = MyBatisUtils.openSession();
        CategoryDAO cdao = ss.getMapper(CategoryDAO.class);
        List<Category> categories = cdao.selectAllCategorys();
        System.out.println("categories = " + categories);
        MyBatisUtils.close(ss);
    }
    @org.junit.Test
    //图书编辑推荐查询
    public void test2(){
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectEditorRecommendBooks();
        System.out.println("books = " + books);
        MyBatisUtils.close(ss);
    }
    @org.junit.Test
    //根据小说类型的一级编号查询到的图书
    public void test3(){
        SqlSession ss = MyBatisUtils.openSession();
        BookDAO bdao = ss.getMapper(BookDAO.class);
        List<Book> books = bdao.selectAllBooksByFirst(1,2,3);
        System.out.println("books = " + books);
        MyBatisUtils.close(ss);
    }
     @org.junit.Test
    //根据小说类型的一级编号查询二级
    public void test4(){
        SqlSession ss = MyBatisUtils.openSession();
         CategoryDAO cdao = ss.getMapper(CategoryDAO.class);
         Category c = cdao.selectCategoryByFirst(1);
         System.out.println("c = " + c);
        MyBatisUtils.close(ss);
    }


}
