package com.grupo_10.grupo_10.controller;

import com.grupo_10.grupo_10.model.Usuarios;
import com.grupo_10.grupo_10.service.UsuariosServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    UsuariosServiceImpl usuariosService;

    public HomeController(UsuariosServiceImpl usuariosService) {
        this.usuariosService = usuariosService;
    }


    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            Usuarios usuario = this.usuariosService.getorCreateuser(principal.getClaims());
            model.addAttribute("usuario" , usuario);

        }
        return "index";
    }
}