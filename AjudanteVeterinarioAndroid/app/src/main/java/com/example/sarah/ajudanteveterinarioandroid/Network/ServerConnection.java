package com.example.sarah.ajudanteveterinarioandroid.Network;

/**
 * Created by sarah on 09/04/2017.
 */
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class ServerConnection {

    private static final String URL_BASES = "http://192.168.0.24:8080/RestEasyApp/";


    private static APIService service;
    private static ServerConnection ourInstance = new ServerConnection();

    public static ServerConnection getInstance() {
        return ourInstance;
    }

    public APIService getService() {
        return service;
    }

    private ServerConnection() {
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
