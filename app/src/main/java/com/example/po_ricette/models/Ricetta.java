package com.example.po_ricette.models;

import java.util.ArrayList;
import java.util.Map;

public class Ricetta {
    private String categoria;
    private String descrizione;
    private int grado_difficolta;
    private String immagine;
    private int tempo_preparazione;
    private ArrayList<Map<String, String>> ingredienti;
    private String nome;
    private String speciale;
    private ArrayList<String> strumenti;

    public Ricetta() {}

    public Ricetta(String classificazione, String descrizione, int grado_difficolta, String immagine, ArrayList<Map<String, String>> ingredienti, String nome, String speciale, ArrayList<String> strumenti, int tempo_preparazione) {
        this.categoria = classificazione;
        this.descrizione = descrizione;
        this.grado_difficolta = grado_difficolta;
        this.immagine = immagine;
        this.ingredienti = ingredienti;
        this.nome = nome;
        this.speciale = speciale;
        this.strumenti = strumenti;
        this.tempo_preparazione=tempo_preparazione;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String classificazione) {
        this.categoria = classificazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getGrado_difficolta() {
        return grado_difficolta;
    }

    public void setGrado_difficolta(int grado_difficolta) {
        this.grado_difficolta = grado_difficolta;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public ArrayList<Map<String, String>> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(ArrayList<Map<String, String>> ingredienti) {
        this.ingredienti = ingredienti;
    }
    public int getTempo_preparazione() {
        return tempo_preparazione;
    }

    public void setTempo_preparazione(int tempo_preparazione) {
        this.tempo_preparazione = tempo_preparazione;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSpeciale() {
        return speciale;
    }

    public void setSpeciale(String speciale) {
        this.speciale = speciale;
    }

    public ArrayList<String> getStrumenti() {
        return strumenti;
    }

    public void setStrumenti(ArrayList<String> strumenti) {
        this.strumenti = strumenti;
    }
}
