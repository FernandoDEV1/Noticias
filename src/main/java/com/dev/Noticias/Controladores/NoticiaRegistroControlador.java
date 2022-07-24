package com.dev.Noticias.Controladores;

import com.dev.Noticias.Servicios.NoticiaServicio;
import com.dev.Noticias.dto.NoticiaRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/agregarnoticia")
public class NoticiaRegistroControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @ModelAttribute("noticia")
    public  NoticiaRegistroDto noticiaRegistroDto(){return  new NoticiaRegistroDto();}

    @GetMapping
    public String mostrarFormularioAgregarNoticia(){
        return "agregarnoticia";
    }

    @PostMapping
    public String agregarNoticia(@ModelAttribute("noticia")NoticiaRegistroDto noticiaRegistroDto, RedirectAttributes redirAttrs){
        noticiaServicio.guardar(noticiaRegistroDto);
        redirAttrs.addFlashAttribute("msjsesion","Se agrego con exito la noticia");
        return "redirect:/inicio";
    }
}
