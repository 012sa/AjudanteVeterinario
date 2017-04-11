package com.example.sarah.ajudanteveterinarioandroid.Network;

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

    @GET("PropriedadeController/id/{id}")
    Call<Propriedade> inserirFazenda(@Path("id") int id);

    @GET("PropriedadeController/listar")
    Call<List<Propriedade>> getFazendas();

    @POST("PropriedadeController/inserir")
    Call<Propriedade> inserirFazenda(@Body Propriedade propriedade);

    @POST("PropriedadeController/deletar")
    Call<Propriedade> deletarFazenda(@Body Propriedade propriedade);

    @POST("PropriedadeController/alterar")
    Call<Propriedade> alterarFazenda(@Body Propriedade propriedade);

}
