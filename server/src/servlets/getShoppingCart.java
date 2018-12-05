package servlets;

import beans.ShoppingCart_bean;
import dao.Commodity_dao;
import dao.ShoppingCart_dao;
import net.sf.json.JSONArray;
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

@WebServlet(name = "getShoppingCart",urlPatterns = "/api/getShoppingCart")
public class getShoppingCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();

            HttpSession session = request.getSession();
            Integer uId = (Integer) session.getAttribute( "uId" );
            ArrayList<ShoppingCart_bean > shoppingCartList = null;
            ShoppingCart_dao shoppingCart_dao = new ShoppingCart_dao();
            JSONArray data = new JSONArray();

            if (uId != null){
                JSONObject rs = new JSONObject();
                shoppingCartList = shoppingCart_dao.getCartListByUId(uId);
                Commodity_dao commodity_dao = new Commodity_dao();
                for (ShoppingCart_bean shoppingCart : shoppingCartList){
                    rs.put("cId",shoppingCart.getcId());
                    rs.put("price",commodity_dao.getPriceByCId(shoppingCart.getcId()));
                    String cName = commodity_dao.getCNameByCId(shoppingCart.getcId());
                    rs.put("cName",cName);
                    rs.put("image",commodity_dao.getImageByCId(shoppingCart.getcId()));
                    data.add(rs);
                }
            }

            out.write(data.toString());
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
