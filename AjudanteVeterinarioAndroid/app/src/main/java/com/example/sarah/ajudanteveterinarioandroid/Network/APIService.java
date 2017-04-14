package com.example.sarah.ajudanteveterinarioandroid.network;
import com.example.sarah.ajudanteveterinarioandroid.entity.Animal;
import com.example.sarah.ajudanteveterinarioandroid.entity.Propriedade;

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

    //SERVIÇO DE FAZENDA/PROPRIEDADE
    @GET("PropriedadeController/id/{id}")
    Call<List<Propriedade>> inserirFazendaid(@Path("id") int id);

    @GET("PropriedadeController/listar")
    Call<List<Propriedade>> getFazendas();

    @POST("PropriedadeController/inserir")
    Call<Propriedade> inserirFazenda(@Body Propriedade propriedade);

    @POST("PropriedadeController/deletar")
    Call<Propriedade> deletarFazenda(@Body Propriedade propriedade);

    @POST("PropriedadeController/alterar")
    Call<Propriedade> alterarFazenda(@Body Propriedade propriedade);


    //SERVIÇO DE ANIMAIS
    @GET("AnimalController/inserir")
    Call<Animal> inserirAnimal(@Body Animal animal);

    @GET("AnimalController/listar")
    Call<List<Animal>> listarAnimal(@Body Animal animal);

    @GET("AnimalController/listar")
    Call<List<Animal>> getAnimal();

    @GET("AnimalController/id/{id}")
    Call<Animal>inserirAnimalid(@Path("id") int id) ;

    @POST("AnimalController/deletar")
    Call<Animal> deletarAnimal(@Body Animal animal);

    @POST("AnimalController/alterar")
    Call<Animal> alterarAnimal(@Body Animal animal);

}
