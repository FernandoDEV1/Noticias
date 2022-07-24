package com.dev.Noticias.Repositorios;

import com.dev.Noticias.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    boolean existsUsuarioByNomUsuario(String nomUsuario);

    Usuario findByNomUsuario(String nomUsuario);
}
