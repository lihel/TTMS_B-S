package ttms.servlet;
/**
 * Created by lmy on 17-12-17.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.google.gson.JsonObject;

import java.util.*;

@WebServlet(name = "UserInfo")
public class UserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json; charset=utf-8");
        HttpSession session = request.getSession(false);
        JsonObject obj = new JsonObject();
        HashMap<String, String> hp = new HashMap<String, String>();
        if (session == null) {
            obj.addProperty("state", false);
        } else {
            obj.addProperty("state", true);
            hp.put("影厅管理", "/studio.jsp");
            hp.put("座位管理", "/seat.jsp");
            if ((Integer) session.getAttribute("type") == 1) {
                hp.put("员工管理", "/employee.jsp");
                hp.put("登陆用户管理", "/user.jsp");
            }
        }
        obj.addProperty("entry", String.valueOf(hp));
        response.getWriter().write(obj.toString());
    }

}
