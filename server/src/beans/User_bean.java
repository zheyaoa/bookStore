package beans;

public class User_bean {
    private Integer uId;
    private String userName;
    private String password;
    private String address;

    public User_bean() {

    }

    public User_bean(Integer uId, String userName, String password, String address) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
