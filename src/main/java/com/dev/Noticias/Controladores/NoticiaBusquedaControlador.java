package com.dev.Noticias.Controladores;

import com.dev.Noticias.Clases.Noticia;
import com.dev.Noticias.Servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/buscarnoticia")
public class NoticiaBusquedaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping
    public String mostrarBusqueda() {return "busqueda";}

    @PostMapping
    public String buscarNoticia(@ModelAttribute("nomNoticia")String nomNoticia, Model model){
        System.out.println("here");
        System.out.println(nomNoticia);
        List<Noticia> noticias = noticiaServicio.buscarNoticiaporEncabezado(nomNoticia);
        System.out.println(noticias);
        model.addAttribute("noticias",noticias);
        return "busqueda";
    }
}
