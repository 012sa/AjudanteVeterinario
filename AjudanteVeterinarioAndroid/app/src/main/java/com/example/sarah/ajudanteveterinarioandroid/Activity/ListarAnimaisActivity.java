package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sarah.ajudanteveterinarioandroid.Entity.Animal;
import com.example.sarah.ajudanteveterinarioandroid.Network.ServerConnection;
import com.example.sarah.ajudanteveterinarioandroid.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarAnimaisActivity extends AppCompatActivity {

    public Integer idanimal;
    ListView animal_lista;
    ArrayAdapter<Animal> animalArrayAdapter;
    List<Animal> animais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_animais);

        Intent inte = getIntent();
        Bundle b = inte.getExtras();

        animal_lista = (ListView) findViewById(R.id.ListViewFazendaslf);
        animais = new ArrayList<Animal>();
        animalArrayAdapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_activated_1, animais);
        animal_lista.setAdapter(animalArrayAdapter);

        animal_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {

                Intent ipfa = new Intent(ListarAnimaisActivity.this, PerfilAnimalActivity.class);
                startActivity(ipfa);
                idanimal = (int) itemId;
                ipfa.putExtra("id", idanimal);

            }

        });

        listarAnimais();

        FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuLF);
        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ima= new Intent(ListarAnimaisActivity.this, MainActivity.class);
                startActivity(ima);

            }
        });
    }

    public void listarAnimais(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<List<Animal>> call = ServerConnection.getInstance().getService().getAnimal();

                Log.i(this.getClass().getName(), "Calling list");

                call.enqueue(new Callback<List<Animal>>() {
                    @Override
                    public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

                        try{

                            if(response.isSuccessful()){

                                List<Animal> animalResponse = response.body();

                                animais.addAll(animalResponse);
                                animalArrayAdapter.notifyDataSetChanged();

                            }
                            else{

                                Log.e(this.getClass().toString(), "Error on calling");

                            }


                        }
                        catch (Exception e){

                            Log.e(this.getClass().toString(), "Error on calling");

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Animal>> call, Throwable t) {

                        Log.e("onFailure", "Error");

                    }
                });
            }
        }).start();
    }
}
