package com.example.sarah.vetajudanteveterinarioandroid.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sarah on 15/04/2017.
 */

public class ConnectionServer {

    private static final String URL_BASES = "http://192.168.0.24:8079/RestEasyApp/";


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
