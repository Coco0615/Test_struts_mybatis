package service.impl;

import dao.CategoryDAO;
import entity.Category;
import org.apache.ibatis.session.SqlSession;
import service.CategoryService;
import util.MyBatisUtils;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    //查询出所有一级类型下所有的二级类型
    @Override
    public List<Category> selectAllCategorys() {
        SqlSession ss = MyBatisUtils.openSession();
        CategoryDAO cdao = ss.getMapper(CategoryDAO.class);
        List<Category> cs = cdao.selectAllCategorys();
        MyBatisUtils.close(ss);
        return cs;
    }
    //根据一级类别编号查询一级类别对象以及所属的二级类别
    //参数是一级类别编号
    @Override
    public Category selectCategoryByFirst(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CategoryDAO cdao = ss.getMapper(CategoryDAO.class);
        Category category = cdao.selectCategoryByFirst(id);
        MyBatisUtils.close(ss);
        return category;
    }
    //根据二级类别编号 查询对应的一级类别对象以及所属的二级类别
    //参数是二级类别编号
    @Override
    public Category selectCategoryBySecond(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CategoryDAO cdao = ss.getMapper(CategoryDAO.class);
        Category category = cdao.selectCategoryBySecond(id);
        MyBatisUtils.close(ss);
        return category;
    }
    //根据类别id查询出类别名称

    @Override
    public String selectCategoryNameById(Integer id) {
        SqlSession ss = MyBatisUtils.openSession();
        CategoryDAO cdao = ss.getMapper(CategoryDAO.class);
        String s = cdao.selectCategoryNameById(id);
        MyBatisUtils.close(ss);
        return s;
    }
}
