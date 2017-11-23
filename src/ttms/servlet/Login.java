package ttms.servlet;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.google.gson.JsonObject;
import ttms.model.User;
import ttms.service.UserSrv;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO:一个账号登陆后，另一个账户登录，会访问前一个账户的内容，所以登陆后需要清除原session
        request.getSession().setAttribute("login", null);
        request.getSession().setAttribute("admin", null);
        request.getSession().setAttribute("manager", null);
        request.getSession().setAttribute("seller", null);
        request.getSession().invalidate();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
//        System.out.println(name);
//        System.out.println(pass);
        String result = "用户名或密码错误!";
        String page = "index.jsp";
        UserSrv userSrv = new UserSrv();
        User user = userSrv.findUserByNo(name).get(0);

/*
        List userList = new ArrayList<User>();
        userList = userSrv.findUserByNo(name);

        System.out.println(userList);

        int size = userList.size();
        for (int i = 0; i < size; i++) {
            //从list获取数据可以通过get方法
            System.out.println(i + "-----------" + userList.get(i));
        }*/
        response.setCharacterEncoding("UTF-8");
        JsonObject jsobjcet = new JsonObject();

        if (name.equals("") || pass.equals("")) {
            result = "用户名或密码不能为空";
          //  request.setAttribute("desc", result);
            jsobjcet.addProperty("info", result);
            jsobjcet.addProperty("state", false);
        } else if (user.getEmp_type() == 1 && user.getEmp_no().equals(name) && user.getEmp_pass().equals(pass)) {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("admin", "ok");
            jsobjcet.addProperty("name", name);
            jsobjcet.addProperty("pass", pass);
            jsobjcet.addProperty("state", true);
            jsobjcet.addProperty("href", "localhost:8000/TTMS/view/HTML/studio.html");
            page = "user.jsp";
        } else if (user.getEmp_type() == 0 && user.getEmp_no().equals(name) && user.getEmp_pass().equals(pass)) {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("manager", "ok");
            page = "studio.jsp";
        } else {
            request.setAttribute("desc", result);
        }

        PrintWriter out = response.getWriter();
        request.getRequestDispatcher(page).forward(request, response);
        //out.write(jsobjcet.toString());
        System.out.println(jsobjcet.toString());
        out.close();
    }

}
