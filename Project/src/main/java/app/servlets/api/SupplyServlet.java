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

public class SupplyServlet extends ApiServlet {
    SupplyService supplyService = new SupplyService();

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Supplier);

            Supplier authorizedUser = (Supplier) getAuthorizedUser(req);
            Long supplyId = getRequestParameter(req);

            Supply supply = supplyService.getById(supplyId);

            if (!supply.getSupplierId().equals(authorizedUser.getId())) {
                resp.sendError(400);
            }

            supplyService.delete(supply.getId());

            sendSuccessResponse(resp);
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
