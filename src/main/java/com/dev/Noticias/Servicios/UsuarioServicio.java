package com.dev.Noticias.Servicios;

import com.dev.Noticias.Clases.Rol;
import com.dev.Noticias.Clases.Usuario;
import com.dev.Noticias.Repositorios.UsuarioRepositorio;
import com.dev.Noticias.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public interface UsuarioServicio extends UserDetailsService {

    boolean existeNomUsuario(String nomUsuario);

    Usuario guardar(UsuarioRegistroDto usuarioRegistroDto);


}
