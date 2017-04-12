package com.example.sarah.ajudanteveterinarioandroid.Entity;

import java.security.PrivateKey;

/**
 * Created by sarah on 11/04/2017.
 */

public class Animal {

    private int id;
    private String raca;
    private String classificacao;
    private String mae;
    private String tipo;
    private String sexo;
    private String nome;
    private String pais;
    private int idade;

    public Animal(Integer id, String raca, String classificacao, String mae, String tipo,
                  String sexo, String nome, String pais, Integer idade){
        this.id = id;
        this.raca = raca;
        this.classificacao = classificacao;
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.mae = mae;
        this.pais = pais;
        this.idade = idade;

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getRaca() {

        return raca;

    }

    public void setRaca(String raca) {

        this.raca = raca;

    }

    public String getClassificacao() {

        return classificacao;

    }

    public void setClassificacao(String classificacao) {

        this.classificacao = classificacao;

    }

    public String getMae() {

        return mae;

    }

    public void setMae(String mae) {

        this.mae = mae;

    }

    public String getTipo() {

        return tipo;
    }

    public void setTipo(String tipo) {

        this.tipo = tipo;

    }

    public String getSexo() {

        return sexo;

    }

    public void setSexo(String sexo) {

        this.sexo = sexo;

    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getPais() {

        return pais;

    }

    public void setPais(String pais) {

        this.pais = pais;

    }

    public int getIdade() {

        return idade;

    }

    public void setIdade(int idade) {

        this.idade = idade;

    }

    public String toString(){

        return( "Animal {id=" + id + ", raca=" + raca + ", nome=" + nome + ", tipo=" + tipo + ", sexo=" + sexo
                + ", mae=" + mae + ", idade=" + idade + "}");

    }
}
