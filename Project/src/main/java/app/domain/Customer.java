package app.domain;

import app.domain.annotations.SQLinformationClass;
import app.domain.annotations.SQLinformationVariable;
import org.json.simple.JSONObject;

@SQLinformationClass(name = "customer")
public class Customer extends AbstractUser {

    @SQLinformationVariable(name = "about_company", SQLtype = "VARCHAR(100)")
    private String aboutCompany;
    @SQLinformationVariable(name = "about_procurement", SQLtype = "VARCHAR(100)")
    private String aboutProcurement;
    @SQLinformationVariable(name = "contacts", SQLtype = "VARCHAR(100)")
    private String contacts;


    public Customer(String nameCompany, String login, String password, String apikey) {
        super(nameCompany, login, password, apikey);
        this.aboutCompany = "";
        this.aboutProcurement = "";
        this.contacts = "";
    }

    public Customer(String nameCompany, String login, String password, String aboutCompany, String aboutProcurement,
                    String contacts, String apikey) {
        super(nameCompany, login, password, apikey);
        this.aboutCompany = aboutCompany;
        this.aboutProcurement = aboutProcurement;
        this.contacts = contacts;
    }

    public Customer() {
    }

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

    public String getAboutProcurement() {
        return aboutProcurement;
    }

    public void setAboutProcurement(String aboutProcurement) {
        this.aboutProcurement = aboutProcurement;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        json.put("id", getId());
        json.put("name", getNameCompany());
        json.put("about", getAboutCompany());
        json.put("procurement", getAboutProcurement());
        json.put("contacts", getContacts());

        return json;
    }
}
