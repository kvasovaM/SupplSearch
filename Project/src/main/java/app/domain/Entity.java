package app.domain;


import app.domain.annotations.SQLinformationVariable;

public  class Entity {
    @SQLinformationVariable(name = "id", SQLtype = "INT(11)", SQLparams = "PRIMARY KEY NOT NULL AUTO_INCREMENT")
    protected Long id;

    public Entity() {
    }

    public Long  getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
