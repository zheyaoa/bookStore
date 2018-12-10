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
    public Boolean addUser(User_bean user) throws Exception{
        String userName = user.getUserName();
        Boolean isExist = judgeExistByUserName(userName);
        if (isExist){
            return false;
        }
        try {
            String sql = "insert into user(username,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return  true;
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
                String username = rs.getString("userName");
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

    public Boolean judgeExistByUserName(String userName)throws Exception{
        Boolean isExist = false;
        try {
            String sql = "select * from user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            //如果查询出结果
            if(rs.next()){
                isExist = true;
                System.out.println("userName is"+rs.getString("username"));
            }
            System.out.print(rs);
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }
        return isExist;
    }
    public Integer getUIdbyUserName(String userName)throws Exception{
        Integer uId = null;
        try{
            String sql = "select uId from user where userName=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            uId = rs.getInt("uId");
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return uId;
    }
    private String getPasswordbyUserName(String userName)throws Exception{
        String password = null;
        System.out.printf(userName);
        try{
            String sql = "select password from user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                password = rs.getString("password");
            }
            System.out.printf(password);
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return password;
    }
    public Integer login(String userName,String password)throws Exception{
        Integer uId = null;
        if(!judgeExistByUserName(userName)){
            return uId;
        }
        if (password.equals(getPasswordbyUserName(userName))){
            uId = getUIdbyUserName(userName);
        }
        return uId;
    }
}
