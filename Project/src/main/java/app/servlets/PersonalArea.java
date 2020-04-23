package app.servlets;

import app.domain.Customer;
import app.domain.Supplier;
import app.service.CustomerService;
import app.service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PersonalArea extends HttpServlet {

    CustomerService customerServices = new CustomerService();
    SupplierService supplierServices = new SupplierService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long id = (Long) session.getAttribute("id");
        String login = (String) session.getAttribute("login");
        String role = (String) session.getAttribute("type");
        if(role.equals("customer")) {
            Customer customer = customerServices.getById(id);
            String password = req.getParameter("password");
            if (!password.equals(""))
                customer.setPassword(password);
            customer.setNameCompany(new String(req.getParameter("nameCompany").getBytes("ISO-8859-1"), "UTF-8"));
            customer.setAboutCompany(new String(req.getParameter("aboutCompany").getBytes("ISO-8859-1"), "UTF-8"));
            customer.setAboutProcurement(new String(req.getParameter("aboutProcurement").getBytes("ISO-8859-1"), "UTF-8"));
            customerServices.change(customer.getId(), customer.getNameCompany(), customer.getLogin(), customer.getPassword(), customer.getAboutCompany(), customer.getAboutProcurement(), customer.getContacts());
        } else
        {
            Supplier supplier = supplierServices.getById(id);
            String password = req.getParameter("password");
            if (!password.equals(""))
                supplier.setPassword(password);
            supplier.setNameCompany(new String(req.getParameter("nameCompany").getBytes("ISO-8859-1"), "UTF-8"));
            supplier.setAboutCompany(new String(req.getParameter("aboutCompany").getBytes("ISO-8859-1"), "UTF-8"));
            supplier.setAboutProduction(new String(req.getParameter("aboutProduction").getBytes("ISO-8859-1"), "UTF-8"));
            supplierServices.change(supplier.getId(), supplier.getNameCompany(), supplier.getLogin(), supplier.getPassword(), supplier.getAboutCompany(), supplier.getAboutProduction(), supplier.getContacts());
        }
        resp.sendRedirect("/personalarea");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long id = (Long) session.getAttribute("id");
        String role = (String) session.getAttribute("type");
        if (role.equals("customer")) {
            Customer customer =customerServices.getById(id);
            req.setAttribute("id", customer.getId());
            req.setAttribute("role", "customer");
            req.setAttribute("login", customer.getLogin());
            req.setAttribute("nameCompany", customer.getNameCompany());
            req.setAttribute("aboutCompany", customer.getAboutCompany());
            req.setAttribute("aboutProcurement", customer.getAboutProcurement());
            req.setAttribute("contacts", customer.getContacts());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/personalarecustomer.jsp");
            requestDispatcher.forward(req, resp);
        } else
        {
            Supplier supplier = supplierServices.getById(id);
            req.setAttribute("id", supplier.getId());
            req.setAttribute("role", "customer");
            req.setAttribute("login", supplier.getLogin());
            req.setAttribute("nameCompany", supplier.getNameCompany());
            req.setAttribute("aboutCompany", supplier.getAboutCompany());
            req.setAttribute("aboutProduction", supplier.getAboutProduction());
            req.setAttribute("contacts", supplier.getContacts());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/personalaresupplier.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
