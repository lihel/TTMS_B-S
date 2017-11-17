package ttms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO:一个账号登陆后，另一个账户登录，会访问前一个账户的内容，所以登陆后需要清除原session
        // request.getSession().setAttribute("login", null);
        // request.getSession().setAttribute("a", null);
        // request.getSession().setAttribute("b", null);
        request.getSession().invalidate();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String result = "用户名、密码错误!";
        String page = "index.jsp";
        if (name == null || pass == null)
        {
            request.setAttribute("desc", result);
        }
        else if (name.equals("aaa") && pass.equals("aaa"))
        {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("a", "ok");
            page = "dir.jsp";
        }
        else if (name.equals("bbb") && pass.equals("bbb"))
        {
            request.setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("b", "ok");
            page = "dir.jsp";
        }
        else
        {
            request.setAttribute("desc", result);
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

}
