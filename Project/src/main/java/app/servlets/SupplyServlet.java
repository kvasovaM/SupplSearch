package app.servlets;

import app.domain.Supply;
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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Supply> supplies = supplyServices.getAll();


        String str = "";
        for (Supply u : supplies)
        {
            str += "<tr><td>" +
                    u.getSupplierNameCompany() + "</td><td>" +
                    u.getCategory() + "</td><td>" +
                    u.getCity() + "</td><td>" +
                    u.getDescription() + "</td><td>" +
                    u.getPlacementDate() + "</td></tr>";

        }
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("supplier")) {
            req.setAttribute("button", "<button type=\"button\" onclick=\"location.href = '/addsupply'\" class=\"btn btn-outline-primary ml-1 mt-1\">Добавить</button>");
        }
        req.setAttribute("cont", str);
        req.setAttribute("supply", "active");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/supply.jsp");
        requestDispatcher.forward(req, resp);

    }
}
