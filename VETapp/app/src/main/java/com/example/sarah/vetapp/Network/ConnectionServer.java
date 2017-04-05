package com.example.sarah.vetapp.Network;

/**
 * Created by Sarah on 04/04/2017.
 */

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class ConnectionServer {

   private static final String URL_BASES = "http://localhost:8080/RestEasyApp/";


    private static APIService service;
    private static ConnectionServer ourInstance = new ConnectionServer();

    public static ConnectionServer getInstance() {
       return ourInstance;
    }

    public APIService getService() {
        return service;
    }

    private ConnectionServer() {
        updateServiceAdress();
    }

    public void updateServiceAdress() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASES)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(APIService.class);
    }
}