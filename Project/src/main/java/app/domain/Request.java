package app.domain;


import app.domain.annotations.SQLinformationClass;
import app.domain.annotations.SQLinformationVariable;

import java.math.BigDecimal;
import java.util.Date;

@SQLinformationClass(name = "request")
public class Request extends Entity{

    @SQLinformationVariable(name = "customer_id", SQLtype = "INT")
    private Long customerId;
    @SQLinformationVariable(name = "customerNameCompany", SQLtype = "VARCHAR(100)")
    private String customerNameCompany;
    @SQLinformationVariable(name = "category", SQLtype = "VARCHAR(100)")
    private String category;
    @SQLinformationVariable(name = "city", SQLtype = "VARCHAR(100)")
    private String city;

    @SQLinformationVariable(name = "order_quantity", SQLtype = "INT(20)")
    private BigDecimal orderQuantity;
    @SQLinformationVariable(name = "order_frequency", SQLtype = "INT(20)")
    private String orderFrequency;
    @SQLinformationVariable(name = "description", SQLtype = "VARCHAR(100)")
    private String description;
    @SQLinformationVariable(name = "placement_date", SQLtype = "DATE")
    private Date placementDate;



    public Request(Long customerId, String customerNameCompany, String category, String city, BigDecimal orderQuantity, String orderFrequency, String description, Date placementDate) {
        this.customerId = customerId;
        this.customerNameCompany = customerNameCompany;
        this.category = category;
        this.city = city;
        this.orderQuantity = orderQuantity;
        this.orderFrequency = orderFrequency;
        this.description = description;
        this.placementDate = placementDate;

    }

    public Request() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomer(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNameCompany() {
        return customerNameCompany;
    }

    public void setCustomerNameCompany(String customerNameCompany) {
        this.customerNameCompany =customerNameCompany;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city =city;
    }



    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderFrequency() {
        return orderFrequency;
    }

    public void setOrderFrequency(String orderFrequency) {
        this.orderFrequency = orderFrequency;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description =description;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }








}
