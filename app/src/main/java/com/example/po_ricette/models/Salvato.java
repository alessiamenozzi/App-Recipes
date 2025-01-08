package com.example.po_ricette.models;

public class Salvato {
    private Ricetta id_ricetta;
    private Utente id_utente;

    public Salvato() {}

    public Salvato(Ricetta id_ricetta, Utente id_utente) {
        this.id_ricetta = id_ricetta;
        this.id_utente = id_utente;
    }

    public Ricetta getId_ricetta() {
        return id_ricetta;
    }

    public void setId_ricetta(Ricetta id_ricetta) {
        this.id_ricetta = id_ricetta;
    }

    public Utente getId_utente() {
        return id_utente;
    }

    public void setId_utente(Utente id_utente) {
        this.id_utente = id_utente;
    }
}
