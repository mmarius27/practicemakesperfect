package ac.practicemakesperfect.practicemakesperfect.service;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.UserCreds;
import ac.practicemakesperfect.practicemakesperfect.model.request.GenericRequestResponse;
import ac.practicemakesperfect.practicemakesperfect.model.request.UpdateCompanyRequest;
import ac.practicemakesperfect.practicemakesperfect.repository.CompanyRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.UserRepository;

@Service
public class CompanyService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CompanyRepository companyRepository;

    public CompanyInfo getCompanyInfoByEmail(String email) {
        
        UserCreds userCreds = userRepository.findByEmail(email);
        CompanyInfo companyInfo = companyRepository.findByUserCredsId(userCreds.getId());

        return companyInfo;
    }

    public CompanyInfo getCompanyInfoById(String id){
        Optional<CompanyInfo> companyInfo = companyRepository.findById(id);

        if(companyInfo.isPresent())
            return companyInfo.get();
        else
            return null;
    }

    public ArrayList<String> getCompanyPostedPosts(String id) {
        Optional<CompanyInfo> companyInfo = companyRepository.findById(id);

        if(companyInfo.isPresent())
            return companyInfo.get().getPostedPosts();
        else
            return null;
    }

    public ArrayList<String> getRequestingCompanyPostedPosts(String email) {
        UserCreds userCreds = userRepository.findByEmail(email);
        CompanyInfo companyInfo = companyRepository.findByUserCredsId(userCreds.getId());

        return companyInfo.getPostedPosts();
    }

    public GenericRequestResponse updateCurrentCompany(UpdateCompanyRequest request, String email) {
        UserCreds userCreds = userRepository.findByEmail(email);
        CompanyInfo companyInfo = companyRepository.findByUserCredsId(userCreds.getId());

        companyInfo.setContactFirstName(request.getContactFirstName());
        companyInfo.setContactSurname(request.getContactSurname());
        companyInfo.setCompanyName(request.getCompanyName());
        companyInfo.setDescription(request.getDescription());
        companyInfo.setContactEmail(request.getContactEmail());
        companyInfo.setContactPhoneNumber(request.getContactPhoneNumber());

        companyRepository.save(companyInfo);

        return new GenericRequestResponse(true, "Company info updated succesfully!");
    }


}
