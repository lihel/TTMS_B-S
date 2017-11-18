package ttms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO:一个账号登陆后，另一个账户登录，会访问前一个账户的内容，所以登陆后需要清除原session
        request.getSession().setAttribute("login", null);
        request.getSession().setAttribute("a", null);
        request.getSession().setAttribute("m", null);
        request.getSession().setAttribute("s", null);
        request.getSession().invalidate();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name);
        System.out.println(pass);
        String result = "用户名或密码错误!";
        String page = "login.jsp";
        if (name.equals("") || pass.equals("")) {
            result = "用户名或密码不能为空";
            request.setAttribute("desc", result);
        } else if (name.equals("admin") && pass.equals("111")) {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("a", "ok");
            page = "dir.jsp";

        } else if (name.equals("manager") && pass.equals("222")) {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("m", "ok");
            page = "dir.jsp";
        }
        else if (name.equals("seller") && pass.equals("333")) {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("s", "ok");
            page = "dir.jsp";
        }
        else {
            request.setAttribute("desc", result);
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

}
