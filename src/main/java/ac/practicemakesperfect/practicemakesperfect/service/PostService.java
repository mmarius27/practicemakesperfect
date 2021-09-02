package ac.practicemakesperfect.practicemakesperfect.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.practicemakesperfect.practicemakesperfect.model.CompanyInfo;
import ac.practicemakesperfect.practicemakesperfect.model.Post;
import ac.practicemakesperfect.practicemakesperfect.model.request.NewPostRequest;
import ac.practicemakesperfect.practicemakesperfect.repository.CompanyRepository;
import ac.practicemakesperfect.practicemakesperfect.repository.PostRepository;
import ac.practicemakesperfect.practicemakesperfect.util.RegexEscaper;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CompanyRepository companyRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void addNewPost(NewPostRequest newPostRequest){

        LocalDateTime timePoint = LocalDateTime.now();

        Post post = new Post(newPostRequest.getPosterId(),
                                newPostRequest.getTitle(),
                                newPostRequest.getDescription(),
                                newPostRequest.getType(),
                                newPostRequest.getCity(),
                                timePoint.format(formatter),
                                newPostRequest.getKeywords());

        Post savedPost = postRepository.save(post);

        Optional<CompanyInfo> poster = companyRepository.findById(newPostRequest.getPosterId());
        if(poster.isPresent()){
            CompanyInfo companyInfo = poster.get();
            companyInfo.addToPostedPosts(savedPost.getId());

            companyRepository.save(companyInfo);
        }
        else{
            System.out.println("NU SE EXISTA!");
        }
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
