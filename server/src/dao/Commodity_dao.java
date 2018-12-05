package dao;

import beans.Commodity_bean;

import java.sql.*;
import java.util.ArrayList;

public class Commodity_dao {
    public Commodity_dao() throws  Exception{
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shopping?"
                    +"user=debian-sys-maint&password=yyx19980917&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            this.conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private Connection conn =  null;
    private ArrayList<Commodity_bean> commodityList = new ArrayList();
    PreparedStatement ps = null;

    public ArrayList getBookListByTypeId(Integer typeId) throws Exception{
        try {
            String sql = "select * from commodity where typeId= ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,typeId);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                Commodity_bean commoditybean = new Commodity_bean();
                commoditybean.setcId(rs.getInt("cId"));
                commoditybean.setTypeId(rs.getInt("typeId"));
                commoditybean.setPrice(rs.getFloat("price"));
                commoditybean.setcName(rs.getString("cName"));
                commoditybean.setDes(rs.getString("des"));
                commoditybean.setImage(rs.getString("image"));
                commodityList.add(commoditybean);
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return commodityList;
    }
    public void addBook(Commodity_bean commoditybean) throws Exception{
        try {
            String sql = "insert into commodity(typeId,cName,price,des,image) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, commoditybean.getTypeId());
            ps.setString(2, commoditybean.getcName());
            ps.setFloat(3, commoditybean.getPrice());
            ps.setString(4, commoditybean.getDes());
            ps.setString(5, commoditybean.getImage());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }
    }

    public String getCNameByCId(Integer cId) throws Exception{
        String cName = null;
        try{
            String sql = "select cName from commodity where cId =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cName = rs.getString("cName");
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cName;
    }
    public Float getPriceByCId(Integer cId) throws Exception{
        Float price = null;
        try{
            String sql = "select price from commodity where cId =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            price = rs.getFloat("price");
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }
        return price;
    }
    public String getImageByCId(Integer cId) throws Exception{
        String image = null;
        try{
            String sql = "select image from commodity where cId =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            image = rs.getString("image");
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }
        return image;
    }

}
