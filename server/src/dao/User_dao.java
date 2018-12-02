package dao;

import beans.User_bean;

import java.sql.*;
import java.util.ArrayList;

public class User_dao {
    private Connection conn =  null;
     PreparedStatement ps = null;

    public User_dao() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shopping?"
                    +"user=debian-sys-maint&password=yyx19980917&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            this.conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void  addUser(User_bean user) throws Exception{
        try {
            String sql = "insert into user(username,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }

    public void changeAddress(Integer uId,String address)throws  Exception{
        try {
            String sql = "update user set address=? where uId=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,address);
            ps.setInt(2,uId);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }

    public ArrayList getUserList() throws Exception{
        ArrayList<User_bean> userList = new ArrayList();
        try {
            String sql = "select * from user";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                Integer uId = rs.getInt("uId");
                Integer username = rs.getInt("userName");
                String password = rs.getString("password");
                String address = rs.getString("address");
                userList.add(new User_bean(uId,username,password,address));
            }
            rs.close();
            stat.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return userList;
    }
}
