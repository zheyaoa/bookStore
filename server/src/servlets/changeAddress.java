package servlets;

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

@WebServlet(name = "changeAddress",urlPatterns = "/api/changeAddress")
public class changeAddress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer out = response.getWriter();

            JSONObject reqJson = JsonReader.receivePost(request);
            HttpSession session = request.getSession();
            Integer uId = (Integer) session.getAttribute( "uId" );
            JSONObject data = new JSONObject();

            if(uId == null){
                data.put("status",0);
            }
            else {
                User_dao user_dao = new User_dao();
                user_dao.changeAddress( reqJson.getInt( "uId" ), reqJson.getString( "address" ) );
                data.put("status",1);
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
