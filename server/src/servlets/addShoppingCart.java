package servlets;

import beans.Order_bean;
import beans.ShoppingCart_bean;
import dao.ShoppingCart_dao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "addShoppingCart",urlPatterns = "/api/addShoppingCart")
public class addShoppingCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();

            JSONObject reqJson = JsonReader.receivePost(request);
            Integer cId = reqJson.getInt("cId");
            HttpSession session = request.getSession();
            Integer uId = uId = (Integer) session.getAttribute( "uId" );

            JSONObject rs = new JSONObject();
            if (uId == null) {
                rs.put( "status", 0 );
            }
            else {
                ShoppingCart_dao shoppingCart_dao = new ShoppingCart_dao();
                ShoppingCart_bean shoppingCart_bean = new ShoppingCart_bean(uId,cId);
                shoppingCart_dao.addCartList( shoppingCart_bean );

                rs.put( "status", 1 );
            }
            out.write( rs.toString() );
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
