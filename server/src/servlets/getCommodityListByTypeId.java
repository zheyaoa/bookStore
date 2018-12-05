package servlets;

import beans.Commodity_bean;
import beans.Order_bean;
import dao.Commodity_dao;
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

@WebServlet(name = "getCommodityListByTypeId",urlPatterns = "/api/getCommodityListByTypeId")
public class getCommodityListByTypeId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();

            JSONObject reqJson = JsonReader.receivePost(request);
            Integer typeId = reqJson.getInt("typeId");
            HttpSession session = request.getSession();
            Commodity_dao commodity_dao = new Commodity_dao();
            ArrayList<Commodity_bean> commodityList = commodity_dao.getBookListByTypeId(typeId);
                JSONArray data = new JSONArray();
                JSONObject obj = new JSONObject();
                for (Commodity_bean commodityItem :commodityList){
                    obj.put("cId",commodityItem.getcId());
                    obj.put("price",commodityItem.getPrice());
                    obj.put("cName",commodityItem.getcName());
                    obj.put("des",commodityItem.getDes());
                    obj.put("image",commodityItem.getImage());
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
