package com.fiap.model;

public class ChatMensagem {
    private String id;
    private String conteudo;
    private String dataenvio;

    public ChatMensagem() {
    }

    public ChatMensagem(String id, String conteudo, String dataenvio) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataenvio = dataenvio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getDataenvio() {
        return dataenvio;
    }

    public void setDataenvio(String dataenvio) {
        this.dataenvio = dataenvio;
    }

    @Override
    public String toString() {
        return "ChatMensagem{" +
                "id='" + id + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataenvio='" + dataenvio + '\'' +
                '}';
    }
}
