package com.dev.Noticias.dto;

import com.dev.Noticias.Clases.Usuario;

public class NoticiaRegistroDto {
    private String encabezado;
    private String descCorta;
    private String cuerpo;
    private String nomUsuario;

    public NoticiaRegistroDto() {
    }

    public NoticiaRegistroDto(String encabezado, String descCorta, String cuerpo, String nomUsuario) {
        this.encabezado = encabezado;
        this.descCorta = descCorta;
        this.cuerpo = cuerpo;
        this.nomUsuario = nomUsuario;
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

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
}
