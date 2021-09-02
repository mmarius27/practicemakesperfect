package ac.practicemakesperfect.practicemakesperfect.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    @GetMapping("/getstudent")
    public String getStudent(Principal principal){

        String name = principal.getName();
        return "get student: " + name;
    }

    @PostMapping("/poststudent")
    public String postStudent(){
        return "post student";
    }
    
}
