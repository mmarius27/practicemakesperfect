package ac.practicemakesperfect.practicemakesperfect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;

public interface CompanyRepository extends MongoRepository<CompanyInfo, String>{
    
    public CompanyInfo findByUserCredsId(String userCredsId);
}
