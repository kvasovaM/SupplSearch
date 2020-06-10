package app.servlets.api;

import app.domain.Customer;
import app.domain.Supplier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SupplierServlet extends ApiServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkApiAccess(req, AccessType.Authorized);

            Long supplierId = getRequestParameter(req);
            Supplier supplier = supplierService.getById(supplierId);

            if (supplier == null) {
                resp.sendError(404);
            }

            resp.setContentType("text/html");
            resp.getWriter().write(supplier.toJSON().toJSONString());
        }
        catch (Exception e) {
            this.sendErrorResponse(resp, e.getMessage());
        }
    }
}
