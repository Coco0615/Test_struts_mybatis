package service;

import entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {
    //查询出所有一级类型下所有的二级类型
    List<Category> selectAllCategorys();
    //根据一级类别编号查询一级类别对象以及所属的二级类别
    //参数是一级类别编号
    Category selectCategoryByFirst(Integer id);

    //根据二级类别编号 查询对应的一级类别对象以及所属的二级类别
    //参数是二级类别编号
    Category selectCategoryBySecond(Integer id);
    //根据类别id查询出类别名称
    String selectCategoryNameById(Integer id);
}
