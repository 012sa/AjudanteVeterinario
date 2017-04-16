package com.example.sarah.vetajudanteveterinarioandroid.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.sarah.vetajudanteveterinarioandroid.R;
import com.example.sarah.vetajudanteveterinarioandroid.entity.Propriedade;
import com.example.sarah.vetajudanteveterinarioandroid.network.ConnectionServer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.sarah.vetajudanteveterinarioandroid.R.id.parent;

public class ListarFazendaActivity extends AppCompatActivity {

    //@BindView(R.id.floatingActionButtonVoltarMenuLF)FloatingActionButton fbvoltarmenu;
    FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuLF);
    //@BindView (R.id.ListViewFazendaslf)ListView lvFazendas;
    ListView lvFazendas = (ListView) findViewById(R.id.ListViewFazendaslf);
    //@BindView(R.id.spinnerLF)Spinner sfazendas;
    Spinner sfazendas = (Spinner) findViewById(R.id.spinnerLF);
    ArrayAdapter<Propriedade> adapter;
    ArrayAdapter<Propriedade> adapterspinner;
    List<Propriedade> propriedades;
    Integer idfazenda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_fazenda);

        propriedades = new ArrayList<Propriedade>();
        adapter = new ArrayAdapter<Propriedade>(this, android.R.layout.simple_list_item_activated_1, propriedades);
        adapterspinner = new ArrayAdapter<Propriedade>(this, android.R.layout.simple_spinner_item, propriedades);
        lvFazendas.setAdapter(adapter);
        sfazendas.setAdapter(adapterspinner);

        listarFazendas();
        listarFazendaspinner();

        sfazendas.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent ipfa = new Intent(ListarFazendaActivity.this, PerfilFazendaActivity.class);
                startActivity(ipfa);
                idfazenda = (int) id;
                ipfa.putExtra("id", idfazenda);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ima = new Intent(ListarFazendaActivity.this, MainActivity.class);
                startActivity(ima);

            }
        });

    }

    public void listarFazendas(){

        new Thread(new Runnable() {

            @Override

            public void run() {
                Call<List<Propriedade>> call = ConnectionServer.getInstance().getService().getFazendas();
                Log.i(this.getClass().getName(), "Calling list");
                call.enqueue(new Callback<List<Propriedade>>() {
                    @Override
                    public void onResponse(Call<List<Propriedade>> call, Response<List<Propriedade>> response) {
                        try{
                            if(response.isSuccessful()){
                                List<Propriedade> fazendasResponse = response.body();
                                propriedades.addAll(fazendasResponse);
                                adapter.notifyDataSetChanged();
                            }else{
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

    public void listarFazendaspinner(){

        new Thread(new Runnable() {

            @Override

            public void run() {
                Call<List<Propriedade>> call = ConnectionServer.getInstance().getService().getFazendas();
                Log.i(this.getClass().getName(), "Calling list");
                call.enqueue(new Callback<List<Propriedade>>() {
                    @Override
                    public void onResponse(Call<List<Propriedade>> call, Response<List<Propriedade>> response) {
                        try{
                            if(response.isSuccessful()){
                                List<Propriedade> fazendasResponse = response.body();
                                propriedades.addAll(fazendasResponse);
                                adapterspinner.notifyDataSetChanged();
                            }else{
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
