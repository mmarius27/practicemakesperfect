package ac.practicemakesperfect.practicemakesperfect.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="post")
public class Post {
    
    @Id
    String id;
    String posterId;
    String title;
    String description;
    String type;
    String city;
    String postDate;
    ArrayList<String> keywords;

    public Post(String posterId, String title, String description, String type, String city, String postDate, ArrayList<String> keywords) {
        this.posterId = posterId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.city = city;
        this.postDate = postDate;
        this.keywords = keywords;
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPostDate() {
        return this.postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public ArrayList<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

}
