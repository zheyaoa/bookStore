package servlets;

import beans.User_bean;
import dao.User_dao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "login",urlPatterns = "/api/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();
            HttpSession session = null;
            JSONObject data = new JSONObject();

            JSONObject reqJson =  JsonReader.receivePost(request);
            String userName = reqJson.getString("username");
            String password = reqJson.getString("password");
            User_dao user_dao = new User_dao();
            Integer uId = user_dao.login(userName,password);

            if (uId != null){
                session = request.getSession();
                session.setAttribute("userName",userName);
                session.setAttribute("uId",uId);
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
