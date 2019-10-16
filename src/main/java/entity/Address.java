package entity;

public class Address {
    private Integer address_id;
    private String address_name;
    private String tel;
    private String receive_address;
    private Integer default_state;
    private Integer user_id;
    private Integer delete_state;

    public Address() {

    }

    public Address(Integer address_id, String address_name, String tel, String receive_address, Integer default_state, Integer user_id, Integer delete_state) {
        this.address_id = address_id;
        this.address_name = address_name;
        this.tel = tel;
        this.receive_address = receive_address;
        this.default_state = default_state;
        this.user_id = user_id;
        this.delete_state = delete_state;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReceive_address() {
        return receive_address;
    }

    public void setReceive_address(String receive_address) {
        this.receive_address = receive_address;
    }

    public Integer getDefault_state() {
        return default_state;
    }

    public void setDefault_state(Integer default_state) {
        this.default_state = default_state;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDelete_state() {
        return delete_state;
    }

    public void setDelete_state(Integer delete_state) {
        this.delete_state = delete_state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address_name='" + address_name + '\'' +
                ", tel='" + tel + '\'' +
                ", receive_address='" + receive_address + '\'' +
                ", default_state=" + default_state +
                ", user_id=" + user_id +
                ", delete_state=" + delete_state +
                '}';
    }
}
