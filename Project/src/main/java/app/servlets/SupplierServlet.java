package app.servlets;

import app.domain.Supplier;
import app.service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SupplierServlet extends HttpServlet {
    SupplierService supplierServices = new SupplierService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Supplier> suppliers = supplierServices.getAll();

        List<String> nameCompany = new ArrayList<>();
        List<String> aboutCompany = new ArrayList<>();
        List<String> aboutProduction = new ArrayList<>();
        List<String> contacts = new ArrayList<>();
        String str = "";
        for (Supplier u : suppliers)
        {
            str += "<tr><td>" +
                    u.getNameCompany() + "</td><td>" +
                    u.getAboutCompany() + "</td><td>" +
                    u.getAboutProduction() + "</td><td>" +
                    u.getContacts()+ "</td></tr>";
            nameCompany.add(u.getNameCompany());
            aboutCompany.add(u.getAboutCompany());
            aboutProduction.add(u.getAboutProduction());
            contacts.add(u.getContacts());
        }
        req.setAttribute("cont", str);
        req.setAttribute("supplier", "active");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/supplier.jsp");
        requestDispatcher.forward(req, resp);
    }
}
