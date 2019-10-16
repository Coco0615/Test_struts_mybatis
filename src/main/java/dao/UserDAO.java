package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    //增
    void insertUser(@Param("u") User u);
    //查
    User selectUserById(@Param("id") Integer id);
    User selectUserByEmail(@Param("email") String email);

}
