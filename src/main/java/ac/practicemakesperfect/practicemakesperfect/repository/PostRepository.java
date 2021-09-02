package ac.practicemakesperfect.practicemakesperfect.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ac.practicemakesperfect.practicemakesperfect.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

    @Query("{$or:[{title: {'$regex': '.*?0.*', $options: \"$i\"}}, {description: {'$regex': '.*?0.*', $options: \"$i\"}}, {company: {'$regex': '.*?0.*', $options: \"$i\"}}]}")
    //@Query("{$or:[{title: /?0/i}, {description: /?0/i}, {company: /?0/i}]}")
    ArrayList<Post> findBySearchString(String searchString);
    
}
