package com.dev.Noticias.Clases;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "noticia")
public class Noticia {

    @Id
    @Column(name = "idnoticia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNoticia;
    @Column(name = "encabezado")
    private String encabezado;
    @Column(name = "desccorta")
    private String descCorta;
    @Column(name = "cuerpo", columnDefinition = "TEXT")
    private String cuerpo;
    @Column(name = "fechapublicacion")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "noticia")
    @OrderBy("fechapublicacion DESC")
    private Set<Comentario> comentarios;

    public Noticia() {
    }

    public Noticia(String encabezado, String descCorta, String cuerpo, LocalDate fechaPublicacion, Usuario usuario) {
        this.encabezado = encabezado;
        this.descCorta = descCorta;
        this.cuerpo = cuerpo;
        this.fechaPublicacion = fechaPublicacion;
        this.usuario = usuario;
    }

    public Long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getDescCorta() {
        return descCorta;
    }

    public void setDescCorta(String descCorta) {
        this.descCorta = descCorta;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
