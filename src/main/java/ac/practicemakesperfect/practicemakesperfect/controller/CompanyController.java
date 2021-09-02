package ac.practicemakesperfect.practicemakesperfect.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.request.GenericRequestResponse;
import ac.practicemakesperfect.practicemakesperfect.model.request.UpdateCompanyRequest;
import ac.practicemakesperfect.practicemakesperfect.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    
    @GetMapping
    public CompanyInfo getCurrentCompany(Principal user){
        
        CompanyInfo companyInfo = companyService.getCompanyInfoByEmail(user.getName());
        return companyInfo;
    }

    @PostMapping
    public GenericRequestResponse updateCurrentCompany(@RequestBody UpdateCompanyRequest request, Principal requestingUser){

        String email = requestingUser.getName();
        GenericRequestResponse updateCompanyResponse = companyService.updateCurrentCompany(request, email);
        
        return updateCompanyResponse;
    }

    @GetMapping("/{id}")
    public CompanyInfo getCompanyBasedOnId(@PathVariable String id){

        CompanyInfo studentInfo = companyService.getCompanyInfoById(id);
        return studentInfo;
    }

    @GetMapping("/{id}/posted-posts")
    public ArrayList<String> getCompanyPostedPosts(@PathVariable String id){
        ArrayList<String> postedPosts = companyService.getCompanyPostedPosts(id);

        return postedPosts;
    }

    @GetMapping("/posted-posts")
    public ArrayList<String> getRequestingCompanyPostedPosts(Principal user){
        String email = user.getName();
        ArrayList<String> postedPosts = companyService.getRequestingCompanyPostedPosts(email);

        return postedPosts;
    }

}
