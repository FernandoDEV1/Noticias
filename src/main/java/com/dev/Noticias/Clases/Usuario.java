package com.dev.Noticias.Clases;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name =  "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "nomusuario"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apepaterno")
    private String apePaterno;
    @Column(name = "apematerno")
    private String apeMaterno;
    @Column(name = "nomusuario")
    private String nomUsuario;
    @Column(name = "contrasena")
    private String contrasena;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersonal", referencedColumnName = "idpersonal")
    private Personal idPersonal;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(
                    name = "idusuario",
                    referencedColumnName = "idusuario",
                    foreignKey = @ForeignKey(name = "fk_usuario_rol")),
            inverseJoinColumns = @JoinColumn(
                    name = "idrol",
                    referencedColumnName = "idrol",
                    foreignKey = @ForeignKey(name = "fk_rol_usuario")))
    private Collection<Rol> roles;
    @OneToMany(mappedBy = "usuario")
    private Set<Noticia> noticias;

    public Usuario() {
    }

    public Usuario(String nombre, String nomUsuario, String apePaterno, String apeMaterno, String contrasena, Collection<Rol> roles) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Personal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Personal idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomusuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Set<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(Set<Noticia> noticias) {
        this.noticias = noticias;
    }
}
