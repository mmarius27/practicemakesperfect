package ac.practicemakesperfect.practicemakesperfect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ac.practicemakesperfect.practicemakesperfect.model.Post;
import ac.practicemakesperfect.practicemakesperfect.service.PostService;
import ac.practicemakesperfect.practicemakesperfect.model.request.NewPostRequest;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public void addNewPost(Principal user, @RequestBody NewPostRequest newPostRequest) {
        postService.addNewPost(newPostRequest, user.getName());
    }

    @PostMapping("/{id}")
    public void updatePost(@PathVariable String id, @RequestBody NewPostRequest newPostRequest){
        postService.updatePost(id, newPostRequest);
    }
    
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable String id) {
        
        return postService.getPostById(id);
    }
    
    @GetMapping
    public ArrayList<Post> getPostBySearchString(@RequestParam String searchString){
        
        return postService.getPostBySearchString(searchString);
    }

    @DeleteMapping("/{id}")
    public void deleteByPostId(@PathVariable String id) {
        postService.deletePost(id);
    }
    
}
