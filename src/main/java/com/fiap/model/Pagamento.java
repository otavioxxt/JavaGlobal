package com.fiap.model;

public class Pagamento {
    private String id;
    private String forma;
    private String valor;

    public Pagamento() {
    }

    public Pagamento(String id, String forma, String valor) {
        this.id = id;
        this.forma = forma;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id='" + id + '\'' +
                ", forma='" + forma + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
