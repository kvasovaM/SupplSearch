package app.domain;

import app.domain.annotations.SQLinformationClass;
import app.domain.annotations.SQLinformationVariable;


import java.util.Date;

@SQLinformationClass(name = "supply")
public class Supply extends Entity{

    @SQLinformationVariable(name = "supplier", SQLtype = "INT")
    private Long supplierId;//под вопросом
    @SQLinformationVariable(name = "supplierNameCompany", SQLtype = "VARCHAR(100)")
    private String supplierNameCompany;
    @SQLinformationVariable(name = "category", SQLtype = "VARCHAR(100)")
    private String category;
    @SQLinformationVariable(name = "city", SQLtype = "VARCHAR(100)")
    private String city;
    @SQLinformationVariable(name = "description", SQLtype = "VARCHAR(100)")
    private String description;
    @SQLinformationVariable(name = "placement_date", SQLtype = "DATE")
    private Date placementDate;


    public Supply(Long supplierId,String supplierNameCompany, String category, String city,  String description,  Date placementDate) {
        this.supplierId = supplierId;
        this.supplierNameCompany = supplierNameCompany;
        this.category = category;
        this.city = city;
        this.description = description;
        this.placementDate = placementDate;
    }

    public Supply() {
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplier(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierNameCompany() {
        return supplierNameCompany;
    }

    public void setSupplierNameCompany(String supplierNameCompany) {
        this.supplierNameCompany =supplierNameCompany;
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
