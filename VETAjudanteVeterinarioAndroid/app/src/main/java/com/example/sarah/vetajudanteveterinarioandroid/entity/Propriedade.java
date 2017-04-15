package com.example.sarah.vetajudanteveterinarioandroid.entity;

/**
 * Created by sarah on 15/04/2017.
 */

public class Propriedade {
    private int id;
    private String propriedade;
    private String proprietario;
    private String email;

    public Propriedade(Integer id, String propriedade, String proprietario, String email) {

        this.propriedade = propriedade;
        this.proprietario = proprietario;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }
}
