package servlets;

import beans.Order_bean;
import beans.User_bean;
import dao.Orders_dao;
import dao.User_dao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "Register",urlPatterns = "/api/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();
            JSONObject data = new JSONObject();

            JSONObject reqJson =  JsonReader.receivePost(request);
            String userName = reqJson.getString("userName");
            String password = reqJson.getString("password");
            User_dao user_dao = new User_dao();
            User_bean user = new User_bean();
            user.setUserName(userName);
            user.setPassword(password);
            Boolean isSuccess = user_dao.addUser(user);

            if (isSuccess){
                data.put("status",1);
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
