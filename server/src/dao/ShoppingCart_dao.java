package dao;

import beans.ShoppingCart_bean;

import java.sql.*;
import java.util.ArrayList;

public class ShoppingCart_dao {
    private Connection conn =  null;
    PreparedStatement ps = null;
    public ShoppingCart_dao()throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shopping?"
                    +"user=debian-sys-maint&password=yyx19980917&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            this.conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList getCartListByUId(Integer uId) throws  Exception{
        ArrayList<ShoppingCart_bean> shoppingCartList = new ArrayList<>();
        try{
            String sql ="select * shoppingCart where uId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uId);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("uId");
                Integer cId = rs.getInt("cId");
                Integer num = rs.getInt("num");
                Float price = rs.getFloat("price");
                ShoppingCart_bean shoppingCart = new ShoppingCart_bean(userId,cId,num,price);
                shoppingCartList.add(shoppingCart);
            }
            ps.close();
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return shoppingCartList;
    }
    public void addCartList(ShoppingCart_bean shoppingCart) throws Exception{
        try {
            String sql = "insert into shoppingCart(uId,cId,num,price) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shoppingCart.getuId());
            ps.setInt(2,shoppingCart.getcId());
            ps.setInt(3,shoppingCart.getNum());
            ps.setFloat(4,shoppingCart.getPrice());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }
}
