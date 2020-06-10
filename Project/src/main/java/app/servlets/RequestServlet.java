package app.servlets;

import app.domain.Customer;
import app.domain.Request;
import app.service.CustomerService;
import app.service.RequestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class RequestServlet extends HttpServlet {
    CustomerService customerServices = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    RequestService requestServices = new RequestService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Request> requests = requestServices.getAll();

        HttpSession mysession = req.getSession();
        Customer customer = mysession.getAttribute("id") != null && mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("customer")
                ? customerServices.getById((Long) (mysession.getAttribute("id"))) : null;

        String filterCity = req.getParameter("city");
        String filterCategory = req.getParameter("category");
        String filterMinQuantity = req.getParameter("minQuantity");
        String filterMaxQuantity = req.getParameter("maxQuantity");

        String str = "";

        for (Request u : requests) {
            if (filterCategory != null && !filterCategory.isEmpty() && !u.getCategory().contains(filterCategory) ||
                    filterCity != null && !filterCity.isEmpty() && !u.getCity().contains(filterCity) ||
                    filterMinQuantity != null && !filterMinQuantity.isEmpty() &&
                            u.getOrderQuantity().compareTo(new BigDecimal(filterMinQuantity)) < 0 ||
                    filterMaxQuantity != null && !filterMaxQuantity.isEmpty() &&
                            u.getOrderQuantity().compareTo(new BigDecimal(filterMaxQuantity)) > 0
            )
                continue;

            String actions = "";

            if (customer != null && u.getCustomerId().equals(customer.getId())) {
                actions = "<a href =\"/deleterequest?id=" + u.getId() + "\">Удалить</a>";
            }

            str += "<tr><td>" +
                    u.getCustomerNameCompany() + "</td><td>" +
                    u.getCategory() + "</td><td>" +
                    u.getCity() + "</td><td>" +
                    u.getOrderQuantity() + "</td><td>" +
                    u.getOrderFrequency() + "</td><td>" +
                    u.getDescription() + "</td><td>" +
                    u.getPlacementDate() + "</td><td>" +
                    actions + "</td></tr>";


        }
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("customer")) {
            req.setAttribute("button", "<button type=\"button\" onclick=\"location.href = '/addrequest'\" class=\"btn btn-outline-primary ml-1 mt-1\">Добавить</button>");
        }
        req.setAttribute("cont", str);
        req.setAttribute("request", "active");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/request.jsp");
        requestDispatcher.forward(req, resp);

    }
}
