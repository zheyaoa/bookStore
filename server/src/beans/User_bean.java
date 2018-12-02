package beans;

public class User_bean {
    private Integer uId;
    private Integer username;
    private String password;
    private String address;

    public User_bean(Integer uId, Integer username, String password, String address) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public Integer getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
