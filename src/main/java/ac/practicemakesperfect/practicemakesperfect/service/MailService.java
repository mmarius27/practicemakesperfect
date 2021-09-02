package ac.practicemakesperfect.practicemakesperfect.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.Post;
import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;
import ac.practicemakesperfect.practicemakesperfect.model.subclasses.Experience;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendRegistrationMail(String email){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Cont inregistrat!");
        message.setText("Contul dumeavoastra a fost creat! Nu uitati sa completati informatiile profilului dumneavoastra!\nO zi frumoasa!");

        javaMailSender.send(message);
        return true;
    }

    public boolean sendApplicationMail(StudentInfo studentInfo, CompanyInfo companyInfo, Post post){

        String subject = "Un nou candidat a aplicat!";
        String text = studentInfo.getFirstName() + " " + studentInfo.getLastName() + " a aplicat pentru postul " + post.getTitle() + ".\n" +
                    "\nStudent email:" + studentInfo.getContactEmail() + 
                    "\nStudent phoneNumber: " + studentInfo.getPhoneNumber() +
                    "\nFaculty: " + studentInfo.getFaculty() + ", year: " + studentInfo.getYearOfStudy() +
                    "\nEducation: ";

        ArrayList<Experience> education = studentInfo.getEducation();
        ArrayList<Experience> experience = studentInfo.getExperience();
        ArrayList<Experience> extracuriculars= studentInfo.getExtracuriculars();

        for(Experience e:education){
            text = text + "From " + e.getStartDate() + "Until " + e.getEndDate() + " at " + e.getCompanyName() + " as " + e.getPostName() + "\n";
        }

        text = text + "\nExperience: ";
        for(Experience e:experience){
            text = text + "From " + e.getStartDate() + "Until " + e.getEndDate() + " at " + e.getCompanyName() + " as " + e.getPostName() + "\n";
        }

        text = text + "\nExtracuriculars: ";
        for(Experience e:extracuriculars){
            text = text + "From " + e.getStartDate() + "Until " + e.getEndDate() + " at " + e.getCompanyName() + " as " + e.getPostName() + "\n";
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(companyInfo.getContactEmail());
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
        return true;
    }


}
