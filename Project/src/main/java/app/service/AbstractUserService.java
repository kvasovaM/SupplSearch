package app.service;

public abstract class AbstractUserService {

    abstract public boolean registration(String nameCompany, String login, String password);

    abstract public Long getIdByLogin(String login);

    abstract public boolean authorization(String login, String password);



    abstract public void delete(Long id);
    abstract  public void change(Long id, String nameCompany, String login, String password, String aboutCompany, String aboutPro, String contacts);




}
