package com.dev.Noticias.Repositorios;

import com.dev.Noticias.Clases.Noticia;
import com.dev.Noticias.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long> {
    List<Noticia> findAllByOrderByFechaPublicacionDesc();

    List<Noticia> findAllByUsuario(Usuario usuario);

    List<Noticia> findAllByEncabezadoContainingIgnoreCase(String encabezado);


}
