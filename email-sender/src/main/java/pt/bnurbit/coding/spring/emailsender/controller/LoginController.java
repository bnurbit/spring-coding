package pt.bnurbit.coding.spring.emailsender.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping
    public String getWelcomePage(){
        return "welcome";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}
