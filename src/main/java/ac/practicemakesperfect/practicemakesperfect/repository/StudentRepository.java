package ac.practicemakesperfect.practicemakesperfect.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;

public interface StudentRepository extends MongoRepository<StudentInfo, String> {
    public StudentInfo findByUserCredsId(String userCredsId);
    public Optional<StudentInfo> findById(String id);
}
