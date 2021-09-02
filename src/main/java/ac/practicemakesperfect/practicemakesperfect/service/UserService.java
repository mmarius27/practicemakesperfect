package ac.practicemakesperfect.practicemakesperfect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;
import ac.practicemakesperfect.practicemakesperfect.model.UserCreds;
import ac.practicemakesperfect.practicemakesperfect.model.request.RegisterRequest;
import ac.practicemakesperfect.practicemakesperfect.model.request.RegisterResponse;
import ac.practicemakesperfect.practicemakesperfect.repository.CompanyRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.StudentRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MailService mailSender;

    public RegisterResponse registerUser(RegisterRequest registerRequest){

        UserCreds existingUser = userRepository.findByEmail(registerRequest.getEmail());
        if(existingUser != null){
            return new RegisterResponse(false, "Registration failed. Email already used!");
        }

        UserCreds userCreds = new UserCreds(registerRequest.getEmail(), passwordEncoder.encode(registerRequest.getPassword()), registerRequest.getRole());
        userRepository.save(userCreds);
       
        if(userCreds.getRole().equals("STUDENT")){
            StudentInfo studentInfo = new StudentInfo(userCreds.getId(), userCreds.getEmail());
            studentRepository.save(studentInfo);

            //TODO:
            //mailSender.sendRegistrationMail(userCreds.getEmail());
            return new RegisterResponse(true, "Student acount registered successfuly.");
        }
        else if(userCreds.getRole().equals("COMPANY")){
            CompanyInfo companyInfo = new CompanyInfo(userCreds.getId(), userCreds.getEmail());
            companyRepository.save(companyInfo);

            //TODO:
            //mailSender.sendRegistrationMail(userCreds.getEmail());
            return new RegisterResponse(true, "Company acount registered successfuly.");
        }
        else{
            return new RegisterResponse(false, "Role unknown!");
        }
    }

    public List<UserCreds> getAllUsers(){
        return userRepository.findAll();
    }

    public UserDetails loadUserByUsername(String email){
        
        UserCreds user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        else{
            return user;
        }
    }
}
