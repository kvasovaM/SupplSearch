package app.domain;

import app.domain.annotations.SQLinformationClass;
import app.domain.annotations.SQLinformationVariable;

@SQLinformationClass(name = "supplier")
public class Supplier extends AbstractUser  {

    @SQLinformationVariable(name = "about_company", SQLtype = "VARCHAR(100)")
    protected String aboutCompany;
    @SQLinformationVariable(name = "about_production", SQLtype = "VARCHAR(100)")
    private String aboutProduction;
    @SQLinformationVariable(name = "contacts", SQLtype = "VARCHAR(100)")
    private String contacts;


    public Supplier(String nameCompany, String login, String password) {
        super(nameCompany, login, password);
        this.aboutCompany = "";
        this.aboutProduction = "";
        this.contacts = "";
    }

    public Supplier(String nameCompany, String login, String password, String aboutCompany, String aboutProduction, String contacts) {
        super(nameCompany, login, password);
        this.aboutCompany = aboutCompany;
        this.aboutProduction = aboutProduction;
        this.contacts = contacts;
    }

    public  Supplier()
    {}



    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getAboutCompany() {
        return aboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        this.aboutCompany = aboutCompany;
    }

    public String getAboutProduction() {
        return aboutProduction;
    }

    public void setAboutProduction(String aboutProduction) {
        this.aboutCompany = aboutProduction;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
