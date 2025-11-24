package com.fiap.model;

public class Triagem {
    private String id;
    private String tipo;
    private String nvUrgencia;

    public Triagem() {
    }

    public Triagem(String id, String tipo, String nvUrgencia) {
        this.id = id;
        this.tipo = tipo;
        this.nvUrgencia = nvUrgencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNvUrgencia() {
        return nvUrgencia;
    }

    public void setNvUrgencia(String nvUrgencia) {
        this.nvUrgencia = nvUrgencia;
    }

    @Override
    public String toString() {
        return "Triagem{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nvUrgencia='" + nvUrgencia + '\'' +
                '}';
    }
}
