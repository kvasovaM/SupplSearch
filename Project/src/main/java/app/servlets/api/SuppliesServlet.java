package app.servlets.api;

import app.domain.Supplier;
import app.domain.Supply;
import app.service.SupplyService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class SuppliesServlet extends ApiServlet {
    SupplyService supplyService = new SupplyService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Authorized);

            JSONArray jsonArray = new JSONArray();

            for (Supply supply : supplyService.getAll()) {
                jsonArray.add(supply.toJSON());
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
            checkApiAccess(req, AccessType.Supplier);

            JSONObject data = getPostJson(req);

            Supplier supplier = supplierService.getById(Long.parseLong(data.get("supplier_id").toString()));

            supplyService.create(supplier.getId(),
                    supplier.getNameCompany(),
                    getJsonRequestParameter(data, "category"),
                    getJsonRequestParameter(data, "city"),
                    getJsonRequestParameter(data, "description"),
                    new Date());

            sendSuccessResponse(resp);
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
