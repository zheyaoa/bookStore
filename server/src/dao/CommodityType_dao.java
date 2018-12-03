package dao;

import beans.CommodityType_bean;

import java.sql.*;
import java.util.ArrayList;

public class CommodityType_dao {
    public ArrayList getTypeList() throws Exception{
        Connection conn =  null;
        ArrayList<CommodityType_bean> commodityTypeList = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shopping?"
            +"user=debian-sys-maint&password=yyx19980917&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            conn = DriverManager.getConnection(url);
            Statement stat = conn.createStatement();
            String querySql = "select * from commodityType";
            ResultSet rs = stat.executeQuery(querySql);
            while (rs.next()){
                Integer typeId = rs.getInt("typeId");
                String typeName = rs.getString("typeName");
                commodityTypeList.add(new CommodityType_bean(typeId,typeName));
            }
            rs.close();
            stat.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return commodityTypeList;
    }
}
