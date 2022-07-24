package com.dev.Noticias.Clases;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrespuesta")
    private Long idRespuesta;
    @Column(name = "texto")
    private String texto;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @Column(name = "fechapublicacion",columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "idcomentario")
    private Comentario comentario;

    public Respuesta() {
    }

    public Respuesta(String texto, Usuario usuario, LocalDateTime fechaPublicacion, Comentario comentario) {
        this.texto = texto;
        this.usuario = usuario;
        this.fechaPublicacion = fechaPublicacion;
        this.comentario = comentario;
    }

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}
