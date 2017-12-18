package ttms.servlet;

import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.HttpSession;

/**
 * Created by lmy on 17-12-17.
 */
@WebServlet(name = "userInfo", urlPatterns = "/userInfo")
public class userInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession(false);
        JsonObject obj = new JsonObject();
        if (session == null) {
            obj.addProperty("login", false);
        } else {
            obj.addProperty("login", true);
            obj.addProperty("emp_name", session.getAttribute("emp_name").toString());
            obj.addProperty("emp_no", session.getAttribute("emp_no").toString());
            obj.addProperty("head_path", session.getAttribute("head_path").toString());
            obj.addProperty("type", (Integer) session.getAttribute("type"));
        }
        Writer out = response.getWriter();
        out.write(obj.toString());
    }
}
