package app.servlets;

import app.domain.Customer;
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
import java.util.List;

public class SupplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    SupplyService supplyServices = new SupplyService();
    SupplierService supplierService = new SupplierService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Supply> supplies = supplyServices.getAll();

        HttpSession mysession = req.getSession();
        Supplier supplier = mysession.getAttribute("id") != null && mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("supplier")
                ? supplierService.getById( (Long)( mysession.getAttribute("id"))) : null;

        String filterCity = req.getParameter("city");
        String filterCategory = req.getParameter("category");

        String str = "";
        for (Supply u : supplies)
        {
            if (filterCategory != null && !filterCategory.isEmpty() && !u.getCategory().contains(filterCategory) ||
                    filterCity != null && !filterCity.isEmpty() && !u.getCity().contains(filterCity))
                continue;

            String actions = "";

            if (supplier != null && u.getSupplierId().equals(supplier.getId())) {
                actions = "<a href =\"/deletesupply?id=" + u.getId() + "\">Удалить</a>";
            }

            str += "<tr><td>" +
                    u.getSupplierNameCompany() + "</td><td>" +
                    u.getCategory() + "</td><td>" +
                    u.getCity() + "</td><td>" +
                    u.getDescription() + "</td><td>" +
                    u.getPlacementDate() + "</td><td>" +
                    actions +
                    "</td></tr>";

        }
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("supplier")) {
            req.setAttribute("button", "<button type=\"button\" onclick=\"location.href = '/addsupply'\" class=\"btn btn-outline-primary ml-1 mt-1\">Добавить</button>");
        }
        req.setAttribute("cont", str);
        req.setAttribute("supply", "active");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/supply.jsp");
        requestDispatcher.forward(req, resp);

    }
}
