package ac.practicemakesperfect.practicemakesperfect.model.request;

import java.util.ArrayList;

import ac.practicemakesperfect.practicemakesperfect.model.subclasses.Experience;

public class UpdateStudentRequest {
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


    public UpdateStudentRequest() {
        this.firstName = "";
        this.lastName = "";
        this.contactEmail = "";
        this.phoneNumber = "";
        this.birthday = "";
        this.description = "";
        this.faculty = "";
        this.yearOfStudy = 1;
        this.education = new ArrayList<Experience>();
        this.experience = new ArrayList<Experience>();
        this.extracuriculars = new ArrayList<Experience>();
    }

    public UpdateStudentRequest(String firstName, String lastName, String contactEmail, String phoneNumber, String birthday, String description, String faculty, Integer yearOfStudy, ArrayList<Experience> education, ArrayList<Experience> experience, ArrayList<Experience> extracuriculars) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.description = description;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.education = education;
        this.experience = experience;
        this.extracuriculars = extracuriculars;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

}
