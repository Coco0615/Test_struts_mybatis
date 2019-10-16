package service;

import entity.Book;
import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //增
    void insertUser(User u);
    //登录
    boolean login(String user_email,String password);


}
