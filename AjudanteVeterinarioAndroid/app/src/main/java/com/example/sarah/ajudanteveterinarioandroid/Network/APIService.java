package com.example.sarah.ajudanteveterinarioandroid.Network;
import com.example.sarah.ajudanteveterinarioandroid.Entity.Animal;
import com.example.sarah.ajudanteveterinarioandroid.Entity.Propriedade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by sarah on 09/04/2017.
 */

public interface APIService {

    @GET("controller/PropriedadeController/id/{id}")
    Call<List<Propriedade>> inserirFazendaid(@Path("id") int id);

    @GET("controller/PropriedadeController/listar")
    Call<List<Propriedade>> getFazendas();

    @POST("controller/PropriedadeController/inserir")
    Call<Propriedade> inserirFazenda(@Body Propriedade propriedade);

    @POST("controller/PropriedadeController/deletar")
    Call<Propriedade> deletarFazenda(@Body Propriedade propriedade);

    @POST("controller/PropriedadeController/alterar")
    Call<Propriedade> alterarFazenda(@Body Propriedade propriedade);

    @GET("controller/AnimalController/inserir")
    Call<Animal> inserirAnimal(@Body Animal animal);

    @GET("controller/AnimalController/listar")
    Call<List<Animal>> listarAnimal(@Body Animal animal);

    @GET("controller/AnimalController/id/{id}")
    Call<Animal>inserirAnimalid(@Path("id") int id) ;

    @POST("controller/AnimalController/deletar")
    Call<Animal> deletarAnimal(@Body Animal animal);

    @POST("controller/AnimalController/alterar")
    Call<Animal> alteraarAnimal(@Body Animal animal);

}
