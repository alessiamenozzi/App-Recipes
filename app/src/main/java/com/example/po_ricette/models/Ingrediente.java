package com.example.po_ricette.models;

public class Ingrediente {
    private String id;
    private String nome;
    private String categoria;

    public Ingrediente() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Ingrediente(String id, String nome, String categoria) {
        this.id = id;
        this.nome=nome;
        this.categoria=categoria;
    }
}
