package action;

import entity.User;
import org.apache.struts2.ServletActionContext;
import service.impl.UserServiceImpl;
import util.MD5Utils;
import util.MailUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAction {
    private String userEmail;
    private String password;
    private String code;
    private String email;
    private Integer send;
    private String nickname;
    //登录
    public String login(){
        UserServiceImpl us = new UserServiceImpl();
        boolean login=false;
        if(userEmail!=null&&password!=null){
            login = us.login(userEmail, MD5Utils.digest(password));
        }
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession ss = req.getSession();
        Object value = ss.getAttribute("value");
        ss.setAttribute("value1","value1");
        if(login){
            if(code==null){
                return "fail";
            }else if(((String)value).equalsIgnoreCase(code)){
                return "selectAllInMain";
            }else {
                return "fail";
            }
        }else {
            return "fail";
        }

    }
    //获取邮箱验证码
    public String yanzhengma(){
        int i = (int) ((Math.random() * 9 + 1) * 1000);
        ServletActionContext.getRequest().getSession().setAttribute("i",i);
        MailUtil.sendSimpleMail(email,i);
        return null;
    }
    //注册
    public String register(){
        int i =(int) ServletActionContext.getRequest().getSession().getAttribute("i");
        if(send.equals(i)){
            UserServiceImpl us = new UserServiceImpl();
            User user = us.selectUserByEmail(email);
            if(user==null){
                us.insertUser(new User(null,email,nickname, MD5Utils.digest(password),null));
                return "register_okJSP";
            }else {
                return "register_formJSP";
            }
        }
        return "register_formJSP";
    }
    //注册ajax
    public String ajax(){
        UserServiceImpl us = new UserServiceImpl();
        User user = us.selectUserByEmail(email);
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setCharacterEncoding("utf-8");
        PrintWriter pw = null;
        try {
            pw = res.getWriter();
            String success = "可以注册";
            String error = "用户名已存在！";
            if(user==null){
                pw.write(success);
            }else {
                pw.write(error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }

        return null;
    }
    //登出
    public String outLogin(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.invalidate();
        return "login_formJSP";
    }
    //set/get


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
