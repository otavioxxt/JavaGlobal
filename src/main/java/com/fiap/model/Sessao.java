package com.fiap.model;

public class Sessao {
    private String id;
    private String data;
    private String status;

    public Sessao() {
    }

    public Sessao(String id, String data, String status) {
        this.id = id;
        this.data = data;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sessao{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
