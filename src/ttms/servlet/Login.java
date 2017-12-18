package ttms.servlet;

import java.io.*;
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
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import ttms.model.Employee;
import ttms.model.User;
import ttms.service.EmployeeSrv;
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
        request.getSession().invalidate();

        EmployeeSrv empsrv = new EmployeeSrv();
        Employee employee = empsrv.findEmployeeByNo(name);
//        System.out.println(employee);

        response.setCharacterEncoding("UTF-8");
        JsonObject jsobjcet = new JsonObject();


        if (name.equals("") || pass.equals("")) {
            result = "用户名或密码不能为空";
            //  request.setAttribute("desc", result);
            jsobjcet.addProperty("info", result);
            jsobjcet.addProperty("login", false);
        } else if (user.getEmp_type() == 1 && user.getEmp_no().equals(name) && user.getEmp_pass().equals(pass)) {
//            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("login", "ok");
            request.getSession().setAttribute("admin", "ok");
            HttpSession session = request.getSession();
            session.setAttribute("emp_no",name);
            session.setAttribute("emp_name",employee.getEmp_name());
            session.setAttribute("type",user.getEmp_type());
            session.setAttribute("head_path",user.getHead_path());
            System.out.println(employee.getEmp_name());
           /* result = "管理员登陆成功";
            jsobjcet.addProperty("info", result);
            jsobjcet.addProperty("login", true);
            jsobjcet.addProperty("type", 1);*/
            page = "user.jsp";
        } else if (user.getEmp_type() == 0 && user.getEmp_no().equals(name) && user.getEmp_pass().equals(pass)) {

            HttpSession session = request.getSession();
            session.setAttribute("emp_no",name);
            session.setAttribute("emp_name",employee.getEmp_name());
            session.setAttribute("type",user.getEmp_type());
            session.setAttribute("head_path",user.getHead_path());

            System.out.println(session.toString());
            page = "studio.jsp";
        } else {
            request.setAttribute("desc", result);
        }

        PrintWriter out = response.getWriter();
//        response.getWriter().write(jsobjcet.toString());
//        System.out.println(jsobjcet.toString());
        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(jsobjcet.toString());
        request.getRequestDispatcher(page).forward(request, response);
        out.close();
    }

}
