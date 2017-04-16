package com.example.sarah.vetajudanteveterinarioandroid.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.sarah.vetajudanteveterinarioandroid.R;
import com.example.sarah.vetajudanteveterinarioandroid.entity.Animal;
import com.example.sarah.vetajudanteveterinarioandroid.network.ConnectionServer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarAnimaisActivity extends AppCompatActivity {

    String propriedadenm;
    //@BindView(R.id.spinnerLA) Spinner spinneranimal;
    Spinner spinneranimal= (Spinner) findViewById(R.id.spinnerLA);
    //@BindView(R.id.ListViewAnimaisLA) ListView animal_lista;
    ListView animal_lista = (ListView) findViewById(R.id.ListViewAnimaisLA);
    //@BindView(R.id.floatingActionButtonAddAnimalLA) FloatingActionButton fbaddanimal;
    FloatingActionButton fbaddanimal = (FloatingActionButton) findViewById(R.id.floatingActionButtonAddAnimalLA);
    //@BindView(R.id.floatingActionButtonVoltarMenuLA) FloatingActionButton fbvoltarmenu;
    FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuLA);
    ArrayAdapter<Animal> animalArrayAdapter, adapter;
    List<Animal> animais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_animais);
        Intent intent = getIntent();
        propriedadenm = (String) intent.getStringExtra("Propriedadeid");
        animais = new ArrayList<Animal>();
        animalArrayAdapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_activated_1, animais);
        adapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_spinner_item, animais);
        animal_lista.setAdapter(animalArrayAdapter);
        spinneranimal.setAdapter(adapter);

        listarAnimais();

        listarAnimaisspinner();

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ima= new Intent(ListarAnimaisActivity.this, MainActivity.class);
                startActivity(ima);

            }
        });

        fbaddanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ica = new Intent(ListarAnimaisActivity.this, MainActivity.class);
                startActivity(ica);
                ica.putExtra("propriedade", propriedadenm);

            }
        });

        spinneranimal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent ipaa = new Intent(ListarAnimaisActivity.this,
                        PerfilAnimalActivity.class);
                startActivity(ipaa);
                Integer idanimal = (int) id;
                ipaa.putExtra("id", idanimal);
                ipaa.putExtra("propriedade",propriedadenm);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void listarAnimais(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<List<Animal>> call = ConnectionServer.getInstance().getService().getAnimalPropriedade(propriedadenm);

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

    public void listarAnimaisspinner(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<List<Animal>> call = ConnectionServer.getInstance().getService().getAnimalPropriedade(propriedadenm);

                Log.i(this.getClass().getName(), "Calling list");

                call.enqueue(new Callback<List<Animal>>() {
                    @Override
                    public void onResponse(Call<List<Animal>> call, Response<List<Animal>> response) {

                        try{

                            if(response.isSuccessful()){

                                List<Animal> animalResponse = response.body();

                                animais.addAll(animalResponse);
                                adapter.notifyDataSetChanged();

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

