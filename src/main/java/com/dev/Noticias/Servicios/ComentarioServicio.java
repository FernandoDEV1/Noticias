package com.dev.Noticias.Servicios;


import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Clases.Noticia;
import com.dev.Noticias.Clases.Usuario;
import com.dev.Noticias.Repositorios.ComentarioRepositorio;
import com.dev.Noticias.Repositorios.NoticiaRepositorio;
import com.dev.Noticias.Repositorios.UsuarioRepositorio;
import com.dev.Noticias.dto.ComentarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ComentarioServicio {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public Comentario guardar(ComentarioRegistroDto comentarioRegistroDto){
        Usuario u = usuarioRepositorio.findByNomUsuario(comentarioRegistroDto.getNomUsuario());
        Noticia n = noticiaRepositorio.getById(comentarioRegistroDto.getIdNoticia());
        Comentario c= new Comentario(
                comentarioRegistroDto.getTexto(),
                u,
                LocalDateTime.now(),
                n
        );
        return comentarioRepositorio.save(c);
    }
}
