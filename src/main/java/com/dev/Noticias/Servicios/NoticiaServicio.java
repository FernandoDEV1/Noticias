package com.dev.Noticias.Servicios;

import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Clases.Noticia;
import com.dev.Noticias.Clases.Usuario;
import com.dev.Noticias.Repositorios.ComentarioRepositorio;
import com.dev.Noticias.Repositorios.NoticiaRepositorio;
import com.dev.Noticias.Repositorios.UsuarioRepositorio;
import com.dev.Noticias.dto.NoticiaRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticiaServicio {
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    public Noticia obtenerNoticiaporId(Long idNoticia){
        return  noticiaRepositorio.getById(idNoticia);
    }

    public List<Noticia> obtenerNoticiasporUsuario(String nomUsuario){
        Usuario u = usuarioRepositorio.findByNomUsuario(nomUsuario);
        return noticiaRepositorio.findAllByUsuario(u);
    }

    public Noticia guardar(NoticiaRegistroDto noticiaRegistroDto){
        Usuario usuario = usuarioRepositorio.findByNomUsuario(noticiaRegistroDto.getNomUsuario());
        Noticia noticia = new Noticia(
                noticiaRegistroDto.getEncabezado(),
                noticiaRegistroDto.getDescCorta(),
                noticiaRegistroDto.getCuerpo(),
                LocalDate.now(),
                usuario
        );

        return  noticiaRepositorio.save(noticia);
    }

    public List<Noticia> obtenerNoticias(){
        return noticiaRepositorio.findAllByOrderByFechaPublicacionDesc();
    }

    public List<Noticia> buscarNoticiaporEncabezado(String encabezado){ return noticiaRepositorio.findAllByEncabezadoContainingIgnoreCase(encabezado);}
}
