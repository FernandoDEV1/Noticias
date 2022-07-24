package com.dev.Noticias.Controladores;

import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Servicios.ComentarioServicio;
import com.dev.Noticias.dto.ComentarioRegistroDto;
import com.dev.Noticias.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentar")
public class ComentarioControlador {

    @Autowired
    ComentarioServicio comentarioServicio;

    @PostMapping
    public String comentar(@ModelAttribute("comentario") ComentarioRegistroDto comentarioRegistroDto){
        comentarioServicio.guardar(comentarioRegistroDto);
        return "redirect:/vernoticia/"+comentarioRegistroDto.getIdNoticia();
    }
}
