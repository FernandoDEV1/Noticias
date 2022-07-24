package com.dev.Noticias.Repositorios;

import com.dev.Noticias.Clases.Comentario;
import com.dev.Noticias.Clases.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepositorio extends JpaRepository<Respuesta, Long> {

}
