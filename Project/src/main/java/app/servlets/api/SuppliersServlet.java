package app.servlets.api;

import app.domain.Customer;
import app.domain.Supplier;
import org.json.simple.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuppliersServlet extends ApiServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Authorized);

            JSONArray jsonArray = new JSONArray();

            for (Supplier supplier : supplierService.getAll()) {
                jsonArray.add(supplier.toJSON());
            }

            resp.setContentType("text/html");
            resp.getWriter().write(jsonArray.toJSONString());
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
