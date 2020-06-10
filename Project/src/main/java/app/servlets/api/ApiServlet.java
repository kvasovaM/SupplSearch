package app.servlets.api;

import app.domain.AbstractUser;
import app.domain.Customer;
import app.domain.Supplier;
import app.service.CustomerService;
import app.service.SupplierService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

enum AccessType {
    Authorized,
    Customer,
    Supplier
}

public class ApiServlet extends HttpServlet {
    protected CustomerService customerService = new CustomerService();
    protected SupplierService supplierService = new SupplierService();

    protected void checkApiAccess(HttpServletRequest req, AccessType mode) throws ServletException {
        AbstractUser user = getAuthorizedUser(req);

        if (user == null) {
            throw new ServletException("Access denied");
        }

        if (mode.equals(AccessType.Customer) && !(user instanceof Customer)) {
            throw new ServletException("Access denied");
        }

        if (mode.equals(AccessType.Supplier) && !(user instanceof Supplier)) {
            throw new ServletException("Access denied");
        }
    }

    protected AbstractUser getAuthorizedUser(HttpServletRequest req) {
        String token = req.getParameter("token");

        if (token == null) {
            token = req.getHeader("token");
        }

        AbstractUser customer = customerService.getByApiKey(token);

        if (customer != null) {
            return customer;
        }

        AbstractUser supplier = supplierService.getByApiKey(token);

        if (supplier != null) {
            return supplier;
        }

        return null;
    }

    protected Long getRequestParameter(HttpServletRequest req) {
        return Long.parseLong(req.getRequestURI().substring(req.getRequestURI().lastIndexOf('/') + 1));
    }

    protected JSONObject getPostJson(HttpServletRequest req) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;

        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null)
            jb.append(line);

        JSONParser parser = new JSONParser();

        try {
            return (JSONObject)parser.parse(jb.toString());
        } catch (ParseException e) {
            return new JSONObject();
        }
    }

    protected String getJsonRequestParameter(JSONObject json, String parameterName) {
        //return new String(json.get(parameterName).toString().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return json.get(parameterName).toString();
    }

    protected void sendSuccessResponse(HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.setContentType("text/plain");
        resp.getWriter().write("success");
    }

    protected void sendErrorResponse(HttpServletResponse resp, String message) throws IOException {
        resp.setStatus(400);
        resp.setContentType("text/plain");
        resp.getWriter().write("Error: " + message);
    }
}
