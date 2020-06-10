package app.servlets.api;

import app.domain.Customer;
import app.domain.Request;
import app.domain.Supplier;
import app.domain.Supply;
import app.service.RequestService;
import app.service.SupplyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends ApiServlet {
    RequestService requestService = new RequestService();

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Customer);

            Customer authorizedUser = (Customer) getAuthorizedUser(req);
            Long requestId = getRequestParameter(req);

            Request request = requestService.getById(requestId);

            if (!request.getCustomerId().equals(authorizedUser.getId())) {
                resp.sendError(400);
            }

            requestService.delete(request.getId());

            sendSuccessResponse(resp);
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
