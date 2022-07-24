package com.dev.Noticias.Servicios;

import com.dev.Noticias.Clases.Rol;
import com.dev.Noticias.Clases.Usuario;
import com.dev.Noticias.Repositorios.UsuarioRepositorio;
import com.dev.Noticias.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImp implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServicioImp(@Lazy BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByNomUsuario(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Credenciales invalidas.");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getNomUsuario(), usuario.getContrasena(), mapRolesToAuthorities(usuario.getRoles()));
    }

    @Override
    public Usuario guardar(UsuarioRegistroDto usuarioRegistroDto){

        Usuario usuario = new Usuario(
                usuarioRegistroDto.getNombre(),
                usuarioRegistroDto.getNomUsuario(),
                usuarioRegistroDto.getApePaterno(),
                usuarioRegistroDto.getApeMaterno(),
                passwordEncoder.encode(usuarioRegistroDto.getContrasena()),
                Arrays.asList(new Rol("ROL_EXTERNO")));

        return usuarioRepositorio.save(usuario);
    }

    public boolean existeNomUsuario(String nomUsuario){

        return usuarioRepositorio.existsUsuarioByNomUsuario(nomUsuario);
    }

}
