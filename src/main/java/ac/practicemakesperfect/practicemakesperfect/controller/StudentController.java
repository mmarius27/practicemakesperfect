package ac.practicemakesperfect.practicemakesperfect.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;
import ac.practicemakesperfect.practicemakesperfect.model.request.ApplyToPostRequest;
import ac.practicemakesperfect.practicemakesperfect.model.request.GenericRequestResponse;
import ac.practicemakesperfect.practicemakesperfect.model.request.UpdateStudentRequest;
import ac.practicemakesperfect.practicemakesperfect.model.request.UpdateStudentResponse;
import ac.practicemakesperfect.practicemakesperfect.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public UpdateStudentResponse updateCurrentStudent(@RequestBody UpdateStudentRequest request, Principal requestingUser){

        String email = requestingUser.getName();
        UpdateStudentResponse updateStudentResponse = studentService.updateCurrentStudent(request, email);
        
        return updateStudentResponse;
    }

    @GetMapping
    public StudentInfo getCurrentStudent(Principal requestingUser){
        
        String email = requestingUser.getName();
        StudentInfo studentInfo = studentService.getStudentInfoByEmail(email);

        return studentInfo;
    }

    @GetMapping("/{id}")
    public StudentInfo getStudentBasedOnId(@PathVariable String id){

        StudentInfo studentInfo = studentService.getStudentInfoById(id);
        return studentInfo;
    }

    @GetMapping("/applied-to-posts")
    public ArrayList<String> getStudentAppliedToPosts(Principal user){
        ArrayList<String> appliedToPosts = studentService.getStudentAppliedToPosts(user.getName());

        return appliedToPosts;
    }

    @PostMapping("/applied-to-posts")
    public GenericRequestResponse addToAppliedToPosts(@RequestBody ApplyToPostRequest postId, Principal user){
        GenericRequestResponse requestResponse = studentService.addToAppliedToPosts(postId, user.getName());

        return requestResponse;
    }

    @DeleteMapping("/applied-to-posts")
    public GenericRequestResponse deleteFromAppliedToPosts(@RequestBody String postId, Principal user){
        GenericRequestResponse requestResponse = studentService.deleteFromAppliedToPosts(postId, user.getName());

        return requestResponse;
    }


}
