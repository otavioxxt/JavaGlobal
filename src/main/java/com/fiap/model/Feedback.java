package com.fiap.model;

public class Feedback {
    private String id;
    private String nota;
    private String comentario;

    public Feedback() {
    }

    public Feedback(String id, String nota, String comentario) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", nota='" + nota + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
