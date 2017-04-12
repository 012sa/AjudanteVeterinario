package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sarah.ajudanteveterinarioandroid.Entity.Propriedade;
import com.example.sarah.ajudanteveterinarioandroid.Network.ServerConnection;
import com.example.sarah.ajudanteveterinarioandroid.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarFazendaActivity extends AppCompatActivity {

    public Integer idfazenda;
    ListView fazenda_lista;
    ArrayAdapter<Propriedade> fazendaArrayAdapter;
    List <Propriedade> propriedade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_fazenda);

        fazenda_lista = (ListView) findViewById(R.id.ListViewFazendaslf);
        propriedade = new ArrayList<Propriedade>();
        fazendaArrayAdapter = new ArrayAdapter<Propriedade>(this, android.R.layout.simple_list_item_activated_1, propriedade);
        fazenda_lista.setAdapter(fazendaArrayAdapter);


        FloatingActionButton fbaddfazenda = (FloatingActionButton) findViewById(R.id.floatingActionButtonAddFazenda);
        fbaddfazenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent icf = new Intent(ListarFazendaActivity.this, CadastrarFazendaActivity.class);
                startActivity(icf);

            }
        });

        FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuLF);
        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ima = new Intent(ListarFazendaActivity.this, MainActivity.class);
                startActivity(ima);

            }
        });

        fazenda_lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
                Intent ipfa = new Intent(ListarFazendaActivity.this, PerfilFazendaActivity.class);
                startActivity(ipfa);
                idfazenda = (int) itemId;
                ipfa.putExtra("id", idfazenda);

            }
        });
        listarFazendas();

    }

    public void listarFazendas(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<List<Propriedade>> call = ServerConnection.getInstance().getService().getFazendas();

                Log.i(this.getClass().getName(), "Calling list");

                call.enqueue(new Callback<List<Propriedade>>() {
                    @Override
                    public void onResponse(Call<List<Propriedade>> call, Response<List<Propriedade>> response) {

                        try{

                            if(response.isSuccessful()){
                                List<Propriedade> propriedadesResponse = response.body();

                                propriedade.addAll(propriedadesResponse);
                                fazendaArrayAdapter.notifyDataSetChanged();

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
                    public void onFailure(Call<List<Propriedade>> call, Throwable t) {

                        Log.e("onFailure", "Error");

                    }
                });
            }
        }).start();
    }
}