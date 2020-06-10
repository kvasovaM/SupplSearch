package app.service;

import app.domain.Customer;
import app.domain.Supplier;
import app.persistence.DAO;
import app.persistence.MySqlDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierService extends AbstractUserService {

    protected DAO<Supplier> supplierDAO = new MySqlDAO<>(Supplier.class);

    public boolean registration(String nameCompany, String login, String password) {
        Supplier employer = new Supplier(nameCompany, login, password, this.generateApiKey());
        HashMap<String, Object> equilMap = new HashMap<>();
        equilMap.put("login", login);
        List<Supplier> suppliers = supplierDAO.readByParams(null, null, equilMap);
        if (suppliers.size() == 0) {
            supplierDAO.create(employer);
            return true;
        }
        return false;
    }

    public Long getIdByLogin(String login) {
        HashMap<String, Object> equil = new HashMap<>();
        equil.put("login", login);
        List<Supplier> suppliers = supplierDAO.readByParams(null, null, equil);
        return suppliers.get(0).getId();
    }

    public boolean authorization(String login, String password) {
        Map<String, Object> equil = new HashMap<>();
        equil.put("login", login);
        equil.put("password", password);
        List<Supplier> suppliers = supplierDAO.readByParams(null, null, equil);
        return suppliers.size() != 0;
    }

    public List<Supplier> getAll() {
        return supplierDAO.readAll();
    }

    public void delete(Long id) {
        supplierDAO.delete(id);
    }

    public Supplier getById(Long id) {
        return supplierDAO.readById(id);
    }

    public Supplier getByApiKey(String apikey) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("apikey", apikey);
        List<Supplier> suppliers = supplierDAO.readByParams(null, null, map);
        return suppliers.isEmpty() ? null : suppliers.get(0);
    }

    public void change(Long id, String nameCompany, String login, String password, String aboutCompany,
                       String aboutProduction, String contacts, String apikey) {
        Supplier supplier = new Supplier(nameCompany, login, password,  aboutCompany, aboutProduction, contacts, apikey );
        supplier.setId(id);
        try {
            supplierDAO.update(supplier);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
