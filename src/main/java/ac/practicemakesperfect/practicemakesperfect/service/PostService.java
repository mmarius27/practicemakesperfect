package ac.practicemakesperfect.practicemakesperfect.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.Post;
import ac.practicemakesperfect.practicemakesperfect.model.StudentInfo;
import ac.practicemakesperfect.practicemakesperfect.model.UserCreds;
import ac.practicemakesperfect.practicemakesperfect.model.request.NewPostRequest;
import ac.practicemakesperfect.practicemakesperfect.repository.CompanyRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.PostRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.StudentRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.UserRepository;
import ac.practicemakesperfect.practicemakesperfect.util.RegexEscaper;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void addNewPost(NewPostRequest newPostRequest, String email){

        UserCreds user = userRepository.findByEmail(email);
        CompanyInfo companyInfo = companyRepository.findByUserCredsId(user.getId());
        String posterId = companyInfo.getId();

        LocalDateTime timePoint = LocalDateTime.now();

        Post post = new Post(   posterId,
                                newPostRequest.getTitle(),
                                newPostRequest.getDescription(),
                                newPostRequest.getType(),
                                newPostRequest.getCity(),
                                timePoint.format(formatter),
                                newPostRequest.getKeywords());
        Post savedPost = postRepository.save(post);

        companyInfo.addToPostedPosts(savedPost.getId());
        companyRepository.save(companyInfo);
    }

    public void updatePost(String id, NewPostRequest newPostRequest) {
        Post post = postRepository.findById(id).get();

        post.setTitle(newPostRequest.getTitle());
        post.setDescription(newPostRequest.getDescription());
        post.setCity(newPostRequest.getCity());
        post.setType(newPostRequest.getType());

        postRepository.save(post);
    }

    public void deletePost(String postId){
        Post post= postRepository.findById(postId).get();
        CompanyInfo companyInfo = companyRepository.findById(post.getPosterId()).get();
        ArrayList<StudentInfo> studentList= studentRepository.findByApplyPost(postId);

        companyInfo.removeFromAddedPosts(postId);
        companyRepository.save(companyInfo);
        for(StudentInfo student: studentList){
            student.deleteToAppliedToPosts(postId);
            studentRepository.save(student);
        }
        postRepository.deleteById(postId);
    }

    public Post getPostById(String id) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isPresent())
            return post.get();
        else
            return null;
    }

    public ArrayList<Post> getPostBySearchString(String searchString) {

        searchString = RegexEscaper.escapeSpecialCaracters(searchString);

        ArrayList<Post> posts = postRepository.findBySearchString(searchString);
        return posts;
    }
    
}
