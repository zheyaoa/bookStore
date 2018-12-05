package servlets;

import beans.Order_bean;
import dao.Orders_dao;
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

@WebServlet(name = "addOrders",urlPatterns = "/api/addOrders")
public class addOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();
            HttpSession session = request.getSession();

            ArrayList<Order_bean> orderList = null;
            Orders_dao orders_dao = new Orders_dao();
            JSONArray jsonArr = JsonReader.receivePostToJsonArray(request);
            Integer uId = (Integer)session.getAttribute("uId");
            JSONObject data = new JSONObject();
            if(uId!=null){
                orderList = new ArrayList<>();
                for (int i=0;i<jsonArr.size();i++){
                    JSONObject jsonObject =  jsonArr.getJSONObject(i);
                    Order_bean order_bean  = new Order_bean();
                    System.out.printf(jsonObject.toString());
                    order_bean.setcId(jsonObject.getInt("cId"));
                    order_bean.setuId(uId);
                    order_bean.setNum(jsonObject.getInt("num"));
                    order_bean.setStatus(0);
                    orderList.add(order_bean);
                }
                data.put("status",1);
                int size = orderList.size();
                orders_dao.addOrders((Order_bean[])orderList.toArray(new Order_bean[size]));
            }else {
                data.put("status",0);
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
