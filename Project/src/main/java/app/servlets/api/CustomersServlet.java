package app.servlets.api;

import app.domain.Customer;
import app.domain.Request;
import app.service.CustomerService;
import app.service.RequestService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class CustomersServlet extends ApiServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Authorized);

            JSONArray jsonArray = new JSONArray();

            for (Customer customer : customerService.getAll()) {
                jsonArray.add(customer.toJSON());
            }

            resp.setContentType("text/html");
            resp.getWriter().write(jsonArray.toJSONString());
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
