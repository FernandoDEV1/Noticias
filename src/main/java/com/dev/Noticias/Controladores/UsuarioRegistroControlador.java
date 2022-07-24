package com.dev.Noticias.Controladores;

import com.dev.Noticias.Servicios.UsuarioServicio;
import com.dev.Noticias.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/registro")
public class UsuarioRegistroControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    public UsuarioRegistroControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDto usuarioRegistroDto(){
        return new UsuarioRegistroDto();
    }

    public UsuarioRegistroControlador() {
    }

    @GetMapping
    public String mostrarFormularioRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioRegistroDto usuarioRegistroDto){

        if(usuarioServicio.existeNomUsuario(usuarioRegistroDto.getNomUsuario())){
            return "redirect:/registro?error_usuario";
            }
       else {
            usuarioServicio.guardar(usuarioRegistroDto);
            return "redirect:/registro?exito";
        }

    }
}
