package com.dev.Noticias.dto;

public class RespuestaRegistroDto {

    private String texto;
    private String nomUsuario;
    private Long idComentario;
    private Long idNoticia;

    public RespuestaRegistroDto() {
    }

    public RespuestaRegistroDto(String texto, String nomUsuario, Long idComentario, Long idNoticia) {
        this.texto = texto;
        this.nomUsuario = nomUsuario;
        this.idComentario = idComentario;
        this.idNoticia = idNoticia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public Long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }
}
