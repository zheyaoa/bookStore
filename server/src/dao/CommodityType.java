package dao;

import beans.Type;

import java.sql.*;
import java.util.ArrayList;

public class CommodityType {
    public ArrayList getTypeList() throws Exception{
        Connection conn =  null;
        ArrayList<Type> typeList = new ArrayList();
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
                typeList.add(new Type(typeId,typeName));
            }
            rs.close();
            stat.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return typeList;
    }
}
