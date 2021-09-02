package ac.practicemakesperfect.practicemakesperfect.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.Post;
import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;
import ac.practicemakesperfect.practicemakesperfect.model.UserCreds;
import ac.practicemakesperfect.practicemakesperfect.model.request.ApplyToPostRequest;
import ac.practicemakesperfect.practicemakesperfect.model.request.GenericRequestResponse;
import ac.practicemakesperfect.practicemakesperfect.model.request.UpdateStudentRequest;
import ac.practicemakesperfect.practicemakesperfect.model.request.UpdateStudentResponse;
import ac.practicemakesperfect.practicemakesperfect.repository.CompanyRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.PostRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.StudentRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.UserRepository;

@Service
public class StudentService {
    @Autowired 
    StudentRepository studentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    MailService mailSender;

    public StudentInfo getStudentInfoByEmail(String email){
        UserCreds user = userRepository.findByEmail(email);
        StudentInfo studentInfo = studentRepository.findByUserCredsId(user.getId());

        return studentInfo;
    }

    public StudentInfo getStudentInfoById(String id){
        Optional<StudentInfo> studentInfo = studentRepository.findById(id);

        if(studentInfo.isPresent())
            return studentInfo.get();
        else
            return null;
    }

    public ArrayList<String> getStudentAppliedToPosts(String email){
        UserCreds user = userRepository.findByEmail(email);
        StudentInfo studentInfo = studentRepository.findByUserCredsId(user.getId());

        return studentInfo.getAplliedToPosts();
    }

    public UpdateStudentResponse updateCurrentStudent(UpdateStudentRequest request, String email) {

        UserCreds user = userRepository.findByEmail(email);
        StudentInfo studentInfo = studentRepository.findByUserCredsId(user.getId());

        studentInfo.setFirstName(request.getFirstName());
        studentInfo.setLastName(request.getLastName());
        studentInfo.setContactEmail(request.getContactEmail());
        studentInfo.setPhoneNumber(request.getPhoneNumber());
        studentInfo.setBirthday(request.getBirthday());
        studentInfo.setDescription(request.getDescription());
        studentInfo.setFaculty(request.getFaculty());
        studentInfo.setYearOfStudy(request.getYearOfStudy());
        studentInfo.setEducation(request.getEducation());
        studentInfo.setExperience(request.getExperience());
        studentInfo.setExtracuriculars(request.getExtracuriculars());

        studentRepository.save(studentInfo);

        return new UpdateStudentResponse(true, "Student Info update succesful!");
    }

    public GenericRequestResponse addToAppliedToPosts(ApplyToPostRequest applyToPostRequest, String email) {

        UserCreds user = userRepository.findByEmail(email);
        StudentInfo studentInfo = studentRepository.findByUserCredsId(user.getId());
        Post post = postRepository.findById(applyToPostRequest.getPostId()).get();
        CompanyInfo companyInfo = companyRepository.findById(post.getPosterId()).get();

        mailSender.sendApplicationMail(studentInfo, companyInfo, post);

        studentInfo.addToAppliedToPosts(post.getId());
        studentInfo = studentRepository.save(studentInfo);

        return new GenericRequestResponse(true, "You've applied succesfully!.");
    }

    public GenericRequestResponse deleteFromAppliedToPosts(String postId, String email) {
        UserCreds user = userRepository.findByEmail(email);
        StudentInfo studentInfo = studentRepository.findByUserCredsId(user.getId());

        studentInfo.deleteToAppliedToPosts(postId);
        studentRepository.save(studentInfo);

        return new GenericRequestResponse(true, "You've unapplied succesfully!.");
    }
}
