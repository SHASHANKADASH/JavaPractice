package models;

public class Topic {

    public Topic() {
    }
    public Topic(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    private String id;
    private String name;
    private String desc;



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
