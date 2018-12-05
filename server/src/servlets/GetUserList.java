package servlets;

import beans.User_bean;
import dao.User_dao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "GetUserList",urlPatterns ="/api/getUserList" )
public class GetUserList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws HTTPException,IOException,IOException{
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Writer out = response.getWriter();
        ArrayList<User_bean> userList = null;
        try {
            User_dao user_dao = new User_dao();
            userList = user_dao.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray data = new JSONArray();
        JSONObject rs = new JSONObject();
        for (User_bean user : userList){
            rs.put("userName",user.getUserName());
            rs.put("password",user.getPassword());
            rs.put("address",user.getAddress());
            data.add(rs);
        }
        out.write(data.toString());
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
