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
import java.util.Date;


public class AddRequestServlet extends HttpServlet {
    RequestService requestServices = new RequestService();
    CustomerService customerServices = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession mysession = request.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("customer")) {

            Request requestC = new Request();

            Customer customer = customerServices.getById( (Long)( mysession.getAttribute("id")));
            requestC.setOrderQuantity(new BigDecimal(request.getParameter("orderQuantity")));
            requestC.setOrderFrequency(new String(request.getParameter("orderFrequency").getBytes("ISO-8859-1"), "UTF-8"));
            requestC.setCustomer((Long) mysession.getAttribute("id"));

            requestC.setPlacementDate(new Date());
            requestC.setCustomerNameCompany(customer.getNameCompany());//нужно ли?
            requestC.setCategory(new String(request.getParameter("category").getBytes("ISO-8859-1"), "UTF-8"));
            requestC.setCity(new String(request.getParameter("city").getBytes("ISO-8859-1"), "UTF-8"));
            requestC.setDescription(new String(request.getParameter("description").getBytes("ISO-8859-1"), "UTF-8"));
            requestServices.create(requestC.getCustomerId(), requestC.getCustomerNameCompany(), requestC.getCategory(), requestC.getCity(),
                    requestC.getOrderQuantity(), requestC.getOrderFrequency(), requestC.getDescription(), requestC.getPlacementDate());
            response.sendRedirect("/request");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("customer")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addrequest.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
