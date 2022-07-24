package com.dev.Noticias.Repositorios;

import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Clases.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {


}
