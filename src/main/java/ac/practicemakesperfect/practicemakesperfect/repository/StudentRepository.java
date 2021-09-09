package ac.practicemakesperfect.practicemakesperfect.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;

public interface StudentRepository extends MongoRepository<StudentInfo, String> {
    public StudentInfo findByUserCredsId(String userCredsId);
    public Optional<StudentInfo> findById(String id);

    @Query("{aplliedToPosts:'?0'}")
    public ArrayList<StudentInfo> findByApplyPost(String postId);

}
