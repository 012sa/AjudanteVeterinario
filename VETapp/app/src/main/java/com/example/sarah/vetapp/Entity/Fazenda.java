package com.example.sarah.vetapp.Entity;

public class Fazenda {

    private int id;
    private String propriedade;
    private String proprietario;
    private String email;

    public Fazenda(String propriedade, String proprietario, String email) {
        this.propriedade = propriedade;
        this.proprietario = proprietario;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fazenda{" +
                "id=" + id +
                ", propriedade='" + propriedade + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}