package ac.practicemakesperfect.practicemakesperfect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.practicemakesperfect.practicemakesperfect.model.request.RegisterRequest;
import ac.practicemakesperfect.practicemakesperfect.model.request.RegisterResponse;
import ac.practicemakesperfect.practicemakesperfect.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }
}
