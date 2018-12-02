package dao;

import beans.Order;

import java.sql.*;
import java.util.ArrayList;

public class Orders {
    private Connection conn =  null;
    private ArrayList<Order> orderList = new ArrayList();
    PreparedStatement ps = null;

    public Orders() throws Exception{
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shopping?"
                    +"user=debian-sys-maint&password=yyx19980917&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            this.conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList getOrderListByUid(Integer uId) throws Exception{
        try {
            String sql = "select * from orders while uId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uId);
            ResultSet rs =  ps.executeQuery(sql);
            HandleResultSet(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return orderList;
    }
    public ArrayList getOrderListByStatus(Integer statusCode) throws Exception{
        //statusCode 0/1/2 未完成/完成/所有
        try {
            if (statusCode == 2){
                getOrderListByStatus(0);
                getOrderListByStatus(1);
            }else {
                String sql = "select * from orders while status=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,statusCode);
                ResultSet rs = ps.executeQuery(sql);
                HandleResultSet(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return orderList;

    }
    public void HandleResultSet(ResultSet rs) throws Exception{
        try {
            while (rs.next()){
                Order order = new Order();
                order.setcId(rs.getInt("cId"));
                order.setNum(rs.getInt("num"));
                order.setoId(rs.getInt("oId"));
                order.setuId(rs.getInt("uId"));
                order.setPrice(rs.getFloat("price"));
                order.setStatus(rs.getInt("status"));
                orderList.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void completeOrder(Integer oId) throws Exception{
        try {
            String sql = "update orders set status=1 while oId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,oId);
            ps.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }
}
