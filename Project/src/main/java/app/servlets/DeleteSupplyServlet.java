package app.servlets;

import app.domain.Customer;
import app.domain.Request;
import app.domain.Supplier;
import app.domain.Supply;
import app.service.CustomerService;
import app.service.RequestService;
import app.service.SupplierService;
import app.service.SupplyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DeleteSupplyServlet extends HttpServlet {
    SupplierService supplierService = new SupplierService();
    SupplyService supplyService = new SupplyService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mysession = req.getSession();

        if (mysession.getAttribute("type") == null || !mysession.getAttribute("type").equals("supplier")) {
            throw new ServletException("Access denied");
        }

        Supplier supplier = supplierService.getById( (Long)( mysession.getAttribute("id")));

        Long supplyId = Long.parseLong(req.getParameter("id"));
        Supply supply = supplyService.getById(supplyId);

        if (supply.getSupplierId().equals(supplier.getId())) {
            supplyService.delete(supplyId);
        }

        resp.sendRedirect("/supply");
    }
}
