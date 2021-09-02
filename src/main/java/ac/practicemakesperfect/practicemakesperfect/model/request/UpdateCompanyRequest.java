package ac.practicemakesperfect.practicemakesperfect.model.request;

public class UpdateCompanyRequest {
    String contactFirstName;
    String contactSurname;
    String companyName;
    String description;
    String contactEmail;
    String contactPhoneNumber;

    public UpdateCompanyRequest() {
    }

    public UpdateCompanyRequest(String contactFirstName, String contactSurname, String companyName, String description, String contactEmail, String contactPhoneNumber) {
        this.contactFirstName = contactFirstName;
        this.contactSurname = contactSurname;
        this.companyName = companyName;
        this.description = description;
        this.contactEmail = contactEmail;
        this.contactPhoneNumber = contactPhoneNumber;
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
}
