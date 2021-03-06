package com.example.sarah.vetajudanteveterinarioandroid.entity;

/**
 * Created by sarah on 15/04/2017.
 */

public class Animal {

    private int id;
    private String raca;
    private String classificacao;
    private String mae;
    private String tipo;
    private String sexo;
    private String nome;
    private int idade;
    private int propriedadeid;

    public int getPropriedadeid() {
        return propriedadeid;
    }

    public void setPropriedadeid(int propriedadeid) {
        this.propriedadeid = propriedadeid;
    }

    public Animal(Integer id, String raca, String classificacao, String mae, String tipo,
                  String sexo, String nome, Integer idade, Integer propriedadeid){
        this.id = id;
        this.raca = raca;
        this.classificacao = classificacao;
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.mae = mae;
        this.idade = idade;
        this.propriedadeid = propriedadeid;

    }

    public Animal(String nome, String raca, String idade, String tipo, String sexo, String mae, String classificacao, Integer propriedadeid) {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
