package app.servlets;

import app.domain.Request;
import app.service.RequestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    RequestService requestServices = new RequestService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Request> requests = requestServices.getAll();


        String str = "";
        for (Request u : requests)
        {
            str += "<tr><td>" +
                    u.getCustomerNameCompany() + "</td><td>" +
                    u.getCategory() + "</td><td>" +
                    u.getCity() + "</td><td>" +
                    u.getOrderQuantity() + "</td><td>" +
                    u.getOrderFrequency() + "</td><td>" +
                    u.getDescription() + "</td><td>" +
                    u.getPlacementDate() + "</td></tr>";

        }
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("customer")) {
            req.setAttribute("button", "<button type=\"button\" onclick=\"location.href = '/addrequest'\" class=\"btn btn-outline-primary ml-1 mt-1\">Добавить</button>");
        }
        req.setAttribute("cont", str);
        req.setAttribute("request", "active");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/request.jsp");
        requestDispatcher.forward(req, resp);

    }
}
