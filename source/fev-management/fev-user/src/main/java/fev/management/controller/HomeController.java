package fev.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/user"})
    public String user() {
    	System.out.print("User");
        return "Hello user";
    }


}
