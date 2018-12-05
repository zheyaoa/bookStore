package servlets;

import beans.Order_bean;
import beans.ShoppingCart_bean;
import dao.Orders_dao;
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

@WebServlet(name = "updateShoppingCartList",urlPatterns = "/api/updateShoppingCartList")
public class updateShoppingCartList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();
            HttpSession session = request.getSession();

            ArrayList<ShoppingCart_bean> shoppingCartList = null;
            ShoppingCart_dao shoppingCart_dao = new ShoppingCart_dao();
            JSONArray jsonArr = JsonReader.receivePost(request).getJSONArray("list");
            Integer uId = (Integer) session.getAttribute("uId");
            JSONObject data = new JSONObject();

            if (uId == null){
                data.put("status",0);
            }else {
                data.put("status",1);
                shoppingCartList = new ArrayList<>();
                for (int i=0;i<jsonArr.size();i++){
                    JSONObject jsonObject =  jsonArr.getJSONObject(i);
                    Integer cId = jsonObject.getInt("cId");
                    ShoppingCart_bean shoppingCart_bean  = new ShoppingCart_bean(uId,cId);
                    shoppingCartList.add(shoppingCart_bean);
                }
                int size = shoppingCartList.size();
                shoppingCart_dao.updateCartListByUId(uId,(ShoppingCart_bean[])shoppingCartList.toArray(new ShoppingCart_bean[size]));
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
