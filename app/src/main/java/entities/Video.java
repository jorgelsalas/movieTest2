package entities;

/**
 * Created by Jorge on 10/09/2015.
 */
public class Video {
    String id;
    String key;
    String name;
    String sitel;


    public Video(String id, String key, String name, String sitel) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.sitel = sitel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSitel() {
        return sitel;
    }

    public void setSitel(String sitel) {
        this.sitel = sitel;
    }
}
