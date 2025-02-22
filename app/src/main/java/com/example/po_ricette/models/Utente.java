package com.example.po_ricette.models;

public class Utente {
    private String id;
    private String nome;
    private String password;

    public Utente() {}

    public Utente(String id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
