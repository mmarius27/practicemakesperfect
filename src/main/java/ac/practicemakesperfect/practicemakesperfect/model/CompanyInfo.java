package ac.practicemakesperfect.practicemakesperfect.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companyinfo")
public class CompanyInfo {
    
    @Id
    String id;
    String userCredsId;
    String contactFirstName;
    String contactSurname;
    String companyName;
    String description;
    String contactEmail;
    String contactPhoneNumber;
    ArrayList<String> postedPosts;


    public CompanyInfo() {
        this.userCredsId = "";
        this.contactFirstName = "";
        this.contactSurname = "";
        this.companyName = "";
        this.description = "";
        this.contactEmail = "";
        this.contactPhoneNumber = "";
        this.postedPosts = new ArrayList<String>();
    }

    public CompanyInfo(String userCredsId, String contactFirstName, String contactSurname, String companyName, String description, String contactEmail, String contactPhoneNumber, ArrayList<String> postedPosts) {
        this.userCredsId = userCredsId;
        this.contactFirstName = contactFirstName;
        this.contactSurname = contactSurname;
        this.companyName = companyName;
        this.description = description;
        this.contactEmail = contactEmail;
        this.contactPhoneNumber = contactPhoneNumber;
        this.postedPosts = postedPosts;
    }

    public CompanyInfo(String userCredsId, String contactEmail) {
        this.userCredsId = userCredsId;
        this.contactFirstName = "";
        this.contactSurname = "";
        this.companyName = "";
        this.description = "";
        this.contactEmail = contactEmail;
        this.contactPhoneNumber = "";
        this.postedPosts = new ArrayList<String>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCredsId() {
        return this.userCredsId;
    }

    public void setUserCredsId(String userCredsId) {
        this.userCredsId = userCredsId;
    }

    public String getContactFirstName() {
        return this.contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactSurname() {
        return this.contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public ArrayList<String> getPostedPosts() {
        return this.postedPosts;
    }

    public void setPostedPosts(ArrayList<String> postedPosts) {
        this.postedPosts = postedPosts;
    }

    public void addToPostedPosts(String id) {
        this.postedPosts.add(id);
    }

}
