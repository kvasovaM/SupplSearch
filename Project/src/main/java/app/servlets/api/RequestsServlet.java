package app.servlets.api;

import app.domain.Customer;
import app.domain.Request;
import app.domain.Supplier;
import app.domain.Supply;
import app.service.RequestService;
import app.service.SupplyService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class RequestsServlet extends ApiServlet {
    RequestService requestService = new RequestService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Authorized);

            JSONArray jsonArray = new JSONArray();

            for (Request request : requestService.getAll()) {
                jsonArray.add(request.toJSON());
            }

            resp.setContentType("text/html");
            resp.getWriter().write(jsonArray.toJSONString());
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Customer);

            JSONObject data = getPostJson(req);

            Customer customer = customerService.getById(Long.parseLong(data.get("customer_id").toString()));

            requestService.create(customer.getId(),
                    customer.getNameCompany(),
                    getJsonRequestParameter(data, "category"),
                    getJsonRequestParameter(data, "city"),
                    new BigDecimal(getJsonRequestParameter(data, "amount")),
                    getJsonRequestParameter(data, "frequency"),
                    getJsonRequestParameter(data, "description"),
                    new Date());

            sendSuccessResponse(resp);
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
