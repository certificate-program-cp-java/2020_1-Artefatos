package br.edu.utfpr.cp.java.helloworld.acesso;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.utfpr.cp.java.helloworld.usuario.UsuarioPrincipal;

@Controller
public class AcessoController {

    @GetMapping("/admin")
    public String adminPage() {
        return "/adminPage.html";
    }

    @GetMapping("/private")
    public String privatePage(HttpServletRequest request, Authentication usuarioPrincipal) {

        request.getSession().setAttribute("usuarioAtual", (UserDetails) usuarioPrincipal.getPrincipal());

        return "/privatePage.html";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "/publicPage.html";
    }

    @GetMapping("/user")
    public String userPage(Model memoria, HttpServletRequest request) {

        var usuarioAtual = (UsuarioPrincipal) request.getSession().getAttribute("usuarioAtual");

        memoria.addAttribute("roles", usuarioAtual.getAuthorities().toString());

        return "/userPage";
    }

}