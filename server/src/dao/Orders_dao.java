package dao;

import beans.Order_bean;

import java.sql.*;
import java.util.ArrayList;

public class Orders_dao {
    private Connection conn =  null;
    private ArrayList<Order_bean> orderBeanList = new ArrayList();
    PreparedStatement ps = null;
    public Orders_dao() throws Exception{
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
        return orderBeanList;
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
        return orderBeanList;

    }
    public void HandleResultSet(ResultSet rs) throws Exception{
        try {
            while (rs.next()){
                Order_bean orderBean = new Order_bean();
                orderBean.setcId(rs.getInt("cId"));
                orderBean.setNum(rs.getInt("num"));
                orderBean.setoId(rs.getInt("oId"));
                orderBean.setuId(rs.getInt("uId"));
                orderBean.setPrice(rs.getFloat("price"));
                orderBean.setStatus(rs.getInt("status"));
                orderBeanList.add(orderBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addOrders(Order_bean [] orders) throws Exception{
        try {
            String sql = "insert into orders(uId,cId,num,status,price)values";
            for (Order_bean order:orders) {
                sql += getOrderSql(order);
            }
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }

    private String getOrderSql(Order_bean order){
        String sql = "("
                +order.getuId()+","
                +order.getcId()+","
                +order.getNum()+","
                +order.getStatus()+","
                +order.getPrice()+","
                +")";
        return sql;
    }

    public void completeOrderbyId(Integer oId) throws Exception{
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
