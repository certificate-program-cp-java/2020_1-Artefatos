package br.edu.utfpr.cp.java.helloworld.apresentacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcessoController {

    @GetMapping("/admin")
    public String adminPage() {
        return "/adminPage.html";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "/privatePage.html";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "/publicPage.html";
    }

    @GetMapping("/user")
    public String userPage(){
        return "/userPage.html";
    }

}