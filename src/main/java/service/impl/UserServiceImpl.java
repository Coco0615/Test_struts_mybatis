package service.impl;

import dao.BookDAO;
import dao.UserDAO;
import entity.Book;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;
import service.BookService;
import service.UserService;
import util.MyBatisUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {
    //注册
    @Override
    public void insertUser(User u) {
        SqlSession ss = MyBatisUtils.openSession();
        UserDAO udao = ss.getMapper(UserDAO.class);
        udao.insertUser(u);
        ss.commit();
        MyBatisUtils.close(ss);
    }
    public User selectUserByEmail(String email){
        SqlSession ss = MyBatisUtils.openSession();
        UserDAO udao = ss.getMapper(UserDAO.class);
        User user = udao.selectUserByEmail(email);
        MyBatisUtils.close(ss);
        return user;
    }
    //登录

    @Override
    public boolean login(String user_email, String password) {
        SqlSession ss = MyBatisUtils.openSession();
        UserDAO udao = ss.getMapper(UserDAO.class);
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession se = req.getSession();

        User u = udao.selectUserByEmail(user_email);

        if(u==null){
            MyBatisUtils.close(ss);
            return false;
        }else if(u.getPassword().equals(password)){
            se.setAttribute("user",u);
            MyBatisUtils.close(ss);
            return true;
        }else {
            MyBatisUtils.close(ss);
            return false;
        }


    }
}
