package app.service;

import app.domain.Request;
import app.persistence.DAO;
import app.persistence.MySqlDAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//import java.util.HashMap;

public class RequestService {

    DAO<Request> requestDAO = new MySqlDAO<>(Request.class);

    public void create(Long customerId, String customerNameCompany, String category, String city, BigDecimal orderQuantity, String orderFrequency, String description, Date placementDate) {
        Request request = new Request(customerId, customerNameCompany, category, city, orderQuantity, orderFrequency, description,  placementDate);
        requestDAO.create(request);
    }

    public void delete(Long id) {
        requestDAO.delete(id);
    }

    public void change(Long id, Long customerId, String customerNameCompany, String category, String city, BigDecimal orderQuantity, String orderFrequency, String description, Date placementDate) {
        Request request = new Request(customerId, customerNameCompany, category, city, orderQuantity, orderFrequency, description,  placementDate);
        request.setId(id);
        try {
            requestDAO.update( request);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public List<Request> getAll() {
        return requestDAO.readAll();
    }

    public Request getById(Long id) {
        return requestDAO.readById(id);
    }
}
