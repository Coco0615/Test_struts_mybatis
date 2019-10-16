package entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer user_id;
    private String user_email;
    private String nick_name;
    private String password;
    private List<Address> addresses;
    public User() {
    }

    public User(Integer user_id, String user_email, String nick_name, String password, List<Address> addresses) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.nick_name = nick_name;
        this.password = password;
        this.addresses = addresses;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", password='" + password + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}

