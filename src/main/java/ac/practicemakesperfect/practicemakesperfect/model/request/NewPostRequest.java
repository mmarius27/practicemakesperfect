package ac.practicemakesperfect.practicemakesperfect.model.request;

import java.util.ArrayList;

public class NewPostRequest {
    String posterId;
    String title;
    String description;
    String type;
    String city;
    ArrayList<String> keywords;

    public NewPostRequest(String posterId, String title, String description, String type, String city, ArrayList<String> keywords) {
        this.posterId = posterId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.city = city;
        this.keywords = keywords;
    }

    public String getPosterId() {
        return this.posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

}
