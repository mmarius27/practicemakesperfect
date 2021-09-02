package ac.practicemakesperfect.practicemakesperfect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ac.practicemakesperfect.practicemakesperfect.model.UserCreds;

public interface UserRepository extends MongoRepository<UserCreds, String> {
    UserCreds findByEmail(String username);
}