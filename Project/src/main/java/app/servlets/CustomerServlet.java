package app.servlets;

import app.domain.Customer;
import app.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    CustomerService customerServices = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerServices.getAll();

        List<String> nameCompany = new ArrayList<>();

        List<String> aboutCompany = new ArrayList<>();
        List<String> aboutProcurement = new ArrayList<>();
        List<String> contacts = new ArrayList<>();
        String str = "";
        for (Customer u : customers)
        {
            str += "<tr><td>" +
                    u.getNameCompany() + "</td><td>" +
                    u.getAboutCompany() + "</td><td>" +
                    u.getAboutProcurement() + "</td><td>" +
                    u.getContacts()+ "</td></tr>";
            nameCompany.add(u.getNameCompany());
            aboutCompany.add(u.getAboutCompany());
            aboutProcurement.add(u.getAboutProcurement());
            contacts.add(u.getContacts());
        }
        req.setAttribute("cont", str);
        req.setAttribute("customer", "active");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/customer.jsp");
        requestDispatcher.forward(req, resp);
    }
}
