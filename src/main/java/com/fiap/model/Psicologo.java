package com.fiap.model;

public class Psicologo {
    private String id;
    private String name;
    private String registro;

    public Psicologo() {
    }

    public Psicologo(String id, String name, String registro) {
        this.id = id;
        this.name = name;
        this.registro = registro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Psicologo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", registro='" + registro + '\'' +
                '}';
    }
}
