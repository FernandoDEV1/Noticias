package com.dev.Noticias.Servicios;

import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Clases.Noticia;
import com.dev.Noticias.Clases.Respuesta;
import com.dev.Noticias.Clases.Usuario;
import com.dev.Noticias.Repositorios.ComentarioRepositorio;
import com.dev.Noticias.Repositorios.NoticiaRepositorio;
import com.dev.Noticias.Repositorios.RespuestaRepositorio;
import com.dev.Noticias.Repositorios.UsuarioRepositorio;
import com.dev.Noticias.dto.ComentarioRegistroDto;
import com.dev.Noticias.dto.RespuestaRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class RespuestaServicio {

    @Autowired
    private RespuestaRepositorio respuestaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    public Respuesta guardar(RespuestaRegistroDto respuestaRegistroDto){
        Usuario u = usuarioRepositorio.findByNomUsuario(respuestaRegistroDto.getNomUsuario());
        Comentario n = comentarioRepositorio.getById(respuestaRegistroDto.getIdComentario());
        Respuesta r= new Respuesta(
                respuestaRegistroDto.getTexto(),
                u,
                LocalDateTime.now(),
                n
        );
        return respuestaRepositorio.save(r);
    }
}
