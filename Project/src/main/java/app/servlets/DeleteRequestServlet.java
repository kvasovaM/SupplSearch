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
import java.util.List;

public class DeleteRequestServlet extends HttpServlet {
    CustomerService customerServices = new CustomerService();
    RequestService requestServices = new RequestService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mysession = req.getSession();

        if (mysession.getAttribute("type") == null || !mysession.getAttribute("type").equals("customer")) {
            throw new ServletException("Access denied");
        }

        Customer customer = customerServices.getById( (Long)( mysession.getAttribute("id")));

        Long requestId = Long.parseLong(req.getParameter("id"));
        Request request = requestServices.getById(requestId);

        if (request.getCustomerId().equals(customer.getId())) {
            requestServices.delete(requestId);
        }

        resp.sendRedirect("/request");
    }
}
