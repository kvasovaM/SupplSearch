package app.servlets;

import app.service.CustomerService;
import app.service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrServlet extends HttpServlet {
    CustomerService customerServices = new CustomerService();
    SupplierService supplierServices = new SupplierService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameCompany = new String(req.getParameter("inputNameCompany").getBytes("ISO-8859-1"), "UTF-8");
        String name =new String( req.getParameter("inputLogin").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("inputPassword").getBytes("ISO-8859-1"), "UTF-8");
        String user = new String(req.getParameter("role").getBytes("ISO-8859-1"), "UTF-8");;
        if (user.equals("customer")) {
            if (customerServices.registration(nameCompany,name, password))
            {
                HttpSession session = req.getSession();
                session.setAttribute("login", name);
                session.setAttribute("type", user);
                session.setAttribute("id", customerServices.getIdByLogin(name));
                resp.sendRedirect("/");
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Пользователь с данным логином уже существует");
            }
        } else
        {
            if (supplierServices.registration(nameCompany, name, password))
            {
                HttpSession session = req.getSession();
                session.setAttribute("login", name);
                session.setAttribute("type", user);
                session.setAttribute("id", supplierServices.getIdByLogin(name));
                resp.sendRedirect("/");
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Пользователь с данным логином уже существует");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/reg.jsp");
        requestDispatcher.forward(req, resp);
    }
}

