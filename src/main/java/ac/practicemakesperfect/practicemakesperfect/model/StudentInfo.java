package ac.practicemakesperfect.practicemakesperfect.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ac.practicemakesperfect.practicemakesperfect.model.subclasses.Experience;

@Document(collection = "studentInfo")
public class StudentInfo {
    
    @Id
    String id;
    String userCredsId;
    String firstName;
    String lastName;
    String contactEmail;
    String phoneNumber;
    String  birthday;
    String description;
    String faculty;
    Integer yearOfStudy;
    ArrayList<Experience> education;
    ArrayList<Experience> experience;
    ArrayList<Experience> extracuriculars;
    ArrayList<String> aplliedToPosts;

    public StudentInfo(String userCredsId, String contactEmail){
        this.userCredsId = userCredsId;
        this.firstName = "";
        this.lastName = "";
        this.contactEmail = contactEmail;
        this.phoneNumber = "";
        this.birthday ="01/01/2000";
        this.description = "";
        this.faculty = "";
        this.yearOfStudy = 1;
        this.education = new ArrayList<Experience>();
        this.experience = new ArrayList<Experience>();
        this.extracuriculars = new ArrayList<Experience>();
        this.aplliedToPosts = new ArrayList<String>();
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String surname) {
        this.firstName = surname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public ArrayList<Experience> getEducation() {
        return this.education;
    }

    public void setEducation(ArrayList<Experience> education) {
        this.education = education;
    }

    public ArrayList<Experience> getExperience() {
        return this.experience;
    }

    public void setExperience(ArrayList<Experience> experience) {
        this.experience = experience;
    }

    public ArrayList<Experience> getExtracuriculars() {
        return this.extracuriculars;
    }

    public void setExtracuriculars(ArrayList<Experience> extracuriculars) {
        this.extracuriculars = extracuriculars;
    }

    public ArrayList<String> getAplliedToPosts() {
        return this.aplliedToPosts;
    }

    public void setAplliedToPosts(ArrayList<String> aplliedToPosts) {
        this.aplliedToPosts = aplliedToPosts;
    }

    public void addToAppliedToPosts(String postId) {
        this.aplliedToPosts.add(postId);
    }

    public void deleteToAppliedToPosts(String postId) {
        this.aplliedToPosts.removeIf(post -> (post.equals(postId)));
    }    

}
