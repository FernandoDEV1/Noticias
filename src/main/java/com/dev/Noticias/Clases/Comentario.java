package com.dev.Noticias.Clases;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomentario")
    private Long idComentario;
    @Column(name = "texto")
    private String texto;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @Column(name = "fechapublicacion",columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaPublicacion;
    @OneToMany(mappedBy = "comentario")
    @OrderBy("fechapublicacion DESC")
    private Set<Respuesta> respuestas;
    @ManyToOne
    @JoinColumn(name = "idnoticia")
    private Noticia noticia;

    public Comentario() {
    }

    public Comentario(String texto, Usuario usuario, LocalDateTime fechaPublicacion) {
        this.texto = texto;
        this.usuario = usuario;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Comentario(String texto, Usuario usuario, LocalDateTime fechaPublicacion, Noticia noticia) {
        this.texto = texto;
        this.usuario = usuario;
        this.fechaPublicacion = fechaPublicacion;
        this.noticia = noticia;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Set<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Set<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
}
