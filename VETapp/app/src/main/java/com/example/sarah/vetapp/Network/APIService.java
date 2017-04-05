package com.example.sarah.vetapp.Network;

import com.example.sarah.vetapp.Entity.Fazenda;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Sarah on 04/04/2017.
 */

public interface APIService {


    @GET("fazenda/id/{id}")
    Call<Fazenda> inserirFazenda(@Path("id") int id);

    @GET("fazenda/listar")
     Call<Fazenda> getFazendas();

    @POST("fazenda/inserir")
    Call<Fazenda> inserirFazenda(@Body Fazenda fazenda);

    @POST("fazenda/deletar")
    Call<Fazenda> deletarFazenda(@Body Fazenda fazenda);

    @POST("fazenda/alterar")
    Call<Fazenda> alterarFazenda(@Body Fazenda fazenda);

}
