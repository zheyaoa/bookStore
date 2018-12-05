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
            String sql ="select * from shoppingCart where uId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uId);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("uId");
                Integer cId = rs.getInt("cId");
                ShoppingCart_bean shoppingCart = new ShoppingCart_bean(userId,cId);
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
        if(judgeExistByUIdAndCId(shoppingCart)){
            return;
        }
        try {
            String sql = "insert into shoppingCart(uId,cId) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shoppingCart.getuId());
            ps.setInt(2,shoppingCart.getcId());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }
    private Boolean judgeExistByUIdAndCId(ShoppingCart_bean shoppingCart){
        Boolean isExist = false;
        try {
            String sql = "select * from shoppingCart where uId=? and cId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shoppingCart.getuId());
            ps.setInt(2,shoppingCart.getcId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                isExist = true;
            }
            rs.close();
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return isExist;
    }
    //先删除uId下的所有列表,再进行添加
    public void updateCartListByUId(Integer uId,ShoppingCart_bean[] cartList) throws  Exception{
        try{
            String sql = "delete from shoppingCart where uId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uId);
            ps.executeUpdate();
            ps.close();
            for (ShoppingCart_bean cart:cartList) {
                addCartList(cart);
            }
        }catch (SQLException e){
            conn.rollback();
        }finally {
        }
    }
}
