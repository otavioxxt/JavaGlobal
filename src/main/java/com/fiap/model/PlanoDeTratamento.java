package com.fiap.model;

public class PlanoDeTratamento {
    private String id;
    private String objetivo;
    private String duracao;

    public PlanoDeTratamento() {
    }

    public PlanoDeTratamento(String id, String objetivo, String duracao) {
        this.id = id;
        this.objetivo = objetivo;
        this.duracao = duracao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "PlanoDeTratamento{" +
                "id='" + id + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", duracao='" + duracao + '\'' +
                '}';
    }
}
