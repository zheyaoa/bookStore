package servlets;

import beans.Order_bean;
import dao.CommodityType_dao;
import dao.Commodity_dao;
import dao.Orders_dao;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Servlet.GetAllOrderList",urlPatterns = "/api/getAllOrderList")
public class GetAllOrderList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();

            ArrayList<Order_bean> orderList = null;
            JSONObject reqJson =  JsonReader.receivePost(request);
            Integer status = reqJson.getInt("status");
            System.out.printf("status:" + status);
            Orders_dao orders_dao = new Orders_dao();
            orderList = orders_dao.getOrderListByStatus(status);


            JSONArray data = new JSONArray();
            JSONObject obj = new JSONObject();
            for (Order_bean orderItem :orderList){
                obj.put("oId",orderItem.getoId());
                obj.put("uId",orderItem.getuId());
                obj.put("cId",orderItem.getcId());
                obj.put("price",orderItem.getPrice());
                obj.put("num",orderItem.getNum());
                obj.put("status",orderItem.getStatus());
                obj.put("cName",orderItem.getCName());
                obj.put("image",orderItem.getImage());
                data.add(obj);
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
