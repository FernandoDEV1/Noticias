package com.dev.Noticias;

import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Clases.Noticia;
import com.dev.Noticias.Servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class PrincipalControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;


    @GetMapping("/")
    public String home(Model model){
        List<Noticia> noticias = noticiaServicio.obtenerNoticias();
        model.addAttribute("noticias",noticias);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/403")
    public String prohibido(){
        return "403";
    }

    @GetMapping("/vernoticia/{id}")
    public String verNoticia(@PathVariable("id") Long id, Model model){
        Noticia noticia = noticiaServicio.obtenerNoticiaporId(id);

        model.addAttribute("noticia",noticia);


        return "vernoticia";}

    @GetMapping("/inicio")
    public String inicio(Model model, Principal  principal){
        List<Noticia> noticias = noticiaServicio.obtenerNoticiasporUsuario(principal.getName());
        model.addAttribute("noticias",noticias);
        return "inicio";}

}
