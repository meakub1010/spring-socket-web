package my.project.spring_socket_react.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Spring boot is working";
    }
}
