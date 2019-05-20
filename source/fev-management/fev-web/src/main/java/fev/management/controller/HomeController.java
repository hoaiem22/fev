package fev.management.controller;

import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/soon"})
    public String home() {
        return "soon";
    }

    @GetMapping("/login")
    public String login() {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
                .getContext().getAuthentication().getAuthorities();
        // if (authorities.toString().contains("ROLE_ADMIN"))
        // return "index";
        if (!authorities.toString().contains("ROLE_ANONYMOUS"))
            return "index";
        return "login";
    }

    @GetMapping("/index")
    public String index() {

        return "index";
    }

    @GetMapping("/maintance")
    public String maintance() {
        return "maintance";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "quiz";
    }

    @GetMapping("/error403")
    public String error403() {
        return "error403";
    }
    
    @GetMapping("/monsite")
    public String monsite() {
        return "Monsite";
    }

}
