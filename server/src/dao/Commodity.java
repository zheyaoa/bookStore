package dao;

import beans.Book;

import java.sql.*;
import java.util.ArrayList;

public class Commodity {
    public Commodity() throws  Exception{
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
    private ArrayList<Book> bookList = new ArrayList();
    PreparedStatement ps = null;

    public ArrayList getBookListByTypeId(Integer typeId) throws Exception{
        try {
            String sql = "select * from commodity while typeId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,typeId);
            ResultSet rs =  ps.executeQuery(sql);
            while (rs.next()){
                 Book book = new Book();
                 book.setcId(rs.getInt("cId"));
                 book.setTypeId(rs.getInt("typeId"));
                 book.setPrice(rs.getFloat("price"));
                 book.setcName(rs.getString("cName"));
                 book.setDes(rs.getString("des"));
                 book.setImage(rs.getString("image"));
                 bookList.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
        return bookList;
    }
    public void addBook(Book book) throws Exception{
        try {
            String sql = "insert into commodity values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,book.getcId());
            ps.setInt(2,book.getTypeId());
            ps.setFloat(3,book.getPrice());
            ps.setString(4,book.getcName());
            ps.setString(5,book.getDes());
            ps.setString(6,book.getImage());
            ps.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            conn = null;
        }
    }
}
