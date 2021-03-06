package com.niteroomcreation.simplewebrest.models.data.domains;

/**
 * Created by monta on 02/12/20
 * please make sure to use credit when you're using people's code
 */
public class Greeting {

    private long id;
    private String content;

    public Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
