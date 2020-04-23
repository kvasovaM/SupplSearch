package app.service;

import app.domain.Supply;
import app.persistence.DAO;
import app.persistence.MySqlDAO;

import java.util.Date;
import java.util.List;

//import java.util.HashMap;

public class SupplyService {
    DAO<Supply> supplyDAO = new MySqlDAO<>(Supply.class);

    public void create(Long supplierId,String supplierNameCompany, String category, String city,  String description,  Date placementDate) {
        Supply supply = new Supply(supplierId, supplierNameCompany, category, city, description,  placementDate);
        supplyDAO.create(supply);
    }

    public void delete(Long id) {
        supplyDAO.delete(id);
    }

    public void change(Long id, Long supplierId,String supplierNameCompany, String category, String city,  String description,  Date placementDate) {
        Supply supply = new Supply(supplierId, supplierNameCompany, category, city, description, placementDate);
        supply.setId(id);
        try {
            supplyDAO.update(supply);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public List<Supply> getAll() {
        return supplyDAO.readAll();
    }

    public Supply getById(Long id) {
        return supplyDAO.readById(id);
    }







}
