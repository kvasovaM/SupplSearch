package app.service;

import app.domain.Customer;
import app.persistence.DAO;
import app.persistence.MySqlDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService extends AbstractUserService {

    protected DAO<Customer> customerDAO = new MySqlDAO<>(Customer.class);


    public boolean registration(String nameCompany, String login, String password) {
        Customer customer = new Customer(nameCompany, login, password);
        HashMap<String, Object> equilMap = new HashMap<>();
        equilMap.put("login", login);
        List<Customer> customers = customerDAO.readByParams(null, null, equilMap);
        if (customers.size() == 0) {
            customerDAO.create(customer);
            return true;
        }
        return false;
    }

    public Long getIdByLogin(String login) {
        HashMap<String, Object> equil = new HashMap<>();
        equil.put("login", login);
        List<Customer> customers = customerDAO.readByParams(null, null, equil);
        return customers.get(0).getId();
    }

    public boolean authorization(String login, String password) {
        Map<String, Object> equil = new HashMap<>();
        equil.put("login", login);
        equil.put("password", password);
        List<Customer> customers = customerDAO.readByParams(null, null, equil);
        return customers.size() != 0;
    }

    public List<Customer> getAll() {
        return customerDAO.readAll();
    }

    public void delete(Long id) {
        customerDAO.delete(id);
    }

    public Customer getById(Long id) {
        return customerDAO.readById(id);
    }


    public void change(Long id, String nameCompany, String login, String password, String aboutCompany, String aboutProcurement, String contacts) {
        Customer customer = new Customer(nameCompany, login, password,  aboutCompany, aboutProcurement, contacts );
        customer.setId(id);
        try {
            customerDAO.update(customer);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}
