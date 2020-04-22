package app.domain;

import app.domain.annotations.SQLinformationVariable;

public abstract class AbstractUser extends Entity {

   @SQLinformationVariable(name = "nameCompany", SQLtype = "VARCHAR(100)", SQLparams = "NOT NULL")
    protected String nameCompany;

    @SQLinformationVariable(name = "login", SQLtype = "VARCHAR(100)", SQLparams = "NOT NULL")
    private String login;

    public AbstractUser() {
    }

    @SQLinformationVariable(name = "password", SQLtype = "VARCHAR(100)", SQLparams = "NOT NULL")
    private String password;


    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AbstractUser( String nameCompany, String login, String password) {
        this.nameCompany=nameCompany;
        this.login = login;
        this.password = password;
    }
}
