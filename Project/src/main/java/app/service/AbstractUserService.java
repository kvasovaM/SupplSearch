package app.service;

import java.util.Random;

public abstract class AbstractUserService {

    abstract public boolean registration(String nameCompany, String login, String password);

    abstract public Long getIdByLogin(String login);

    abstract public boolean authorization(String login, String password);



    abstract public void delete(Long id);
    abstract  public void change(Long id, String nameCompany, String login, String password, String aboutCompany,
                                 String aboutPro, String contacts, String apikey);

    public String generateApiKey() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();

        while(sb.length() < 32){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, 32);
    }
}
