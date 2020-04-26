package app.servlets;

import app.domain.Supplier;
import app.domain.Supply;
import app.service.SupplierService;
import app.service.SupplyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


public class AddSupplyServlet extends HttpServlet {
    SupplyService supplyServices = new SupplyService();
    SupplierService supplierServices = new SupplierService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession mysession = request.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("supplier")) {

            Supply supply = new Supply();


            supply.setSupplier((Long) mysession.getAttribute("id"));
            supply.setPlacementDate(new Date());
            Supplier supplier = supplierServices.getById( (Long)( mysession.getAttribute("id")));

            supply.setSupplierNameCompany(supplier.getNameCompany());//нужно ли?

            supply.setCategory(new String(request.getParameter("category").getBytes("ISO-8859-1"), "UTF-8"));
            supply.setCity(new String(request.getParameter("city").getBytes("ISO-8859-1"), "UTF-8"));
            supply.setDescription(new String(request.getParameter("description").getBytes("ISO-8859-1"), "UTF-8"));
            supplyServices.create(supply.getSupplierId(), supply.getSupplierNameCompany(), supply.getCategory(), supply.getCity(),
                    supply.getDescription(), supply.getPlacementDate());
            response.sendRedirect("/supply");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("supplier")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addsupply.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
