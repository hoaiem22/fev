package fev.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/soon"})
    public String home() {
        return "soon";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/index")
    public String index() {
        return "maintance";
    }
    
    @GetMapping("/maintance")
    public String maintance() {
        return "maintance";
    }
    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }
}
