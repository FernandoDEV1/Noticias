package com.dev.Noticias.dto;

public class ComentarioRegistroDto {

    private String texto;
    private String nomUsuario;
    private Long idNoticia;

    public ComentarioRegistroDto() {
    }

    public ComentarioRegistroDto(String texto, String nomUsuario, Long idNoticia) {
        this.texto = texto;
        this.nomUsuario = nomUsuario;
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

    public Long getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }

    @Override
    public String toString() {
        return "ComentarioRegistroDto{" +
                "texto='" + texto + '\'' +
                ", nomUsuario='" + nomUsuario + '\'' +
                ", idNoticia=" + idNoticia +
                '}';
    }
}
