package com.dev.Noticias.Controladores;

import com.dev.Noticias.Servicios.RespuestaServicio;
import com.dev.Noticias.dto.ComentarioRegistroDto;
import com.dev.Noticias.dto.RespuestaRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/responder")
public class RespuestaControlador {

    @Autowired
    RespuestaServicio respuestaServicio;

    @PostMapping
    public String responder(@ModelAttribute("respuesta") RespuestaRegistroDto respuestaRegistroDto){
        respuestaServicio.guardar(respuestaRegistroDto);
        return "redirect:/vernoticia/"+respuestaRegistroDto.getIdNoticia();
    }
}
