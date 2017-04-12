package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.ajudanteveterinarioandroid.Entity.Propriedade;
import com.example.sarah.ajudanteveterinarioandroid.Network.ServerConnection;
import com.example.sarah.ajudanteveterinarioandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFazendaActivity extends AppCompatActivity {

    Integer id;
    List<Propriedade> listpropriedade;
    EditText etpropriedade, etproprietario, etemail;
    Propriedade oproriedade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_fazenda);
        etpropriedade = (EditText) findViewById(R.id.edittextPropriedadePF);
        etproprietario = (EditText) findViewById(R.id.edittextProprietarioPF);
        etemail = (EditText) findViewById(R.id.edittextEmailPF);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        if (b!=null){

            String stid = (String) b.get("id");
            id = Integer.parseInt(stid);

        }

        FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuPF);
        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ima = new Intent(PerfilFazendaActivity.this, MainActivity.class);
                startActivity(ima);

            }
        });

        FloatingActionButton fbalterar = (FloatingActionButton) findViewById(R.id.floatingActionButtonAlterar);
        fbalterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nmpropriedade = etpropriedade.getText().toString();
                final String nmproprietario = etproprietario.getText().toString();
                final String nmemail = etemail.getText().toString();

                final Propriedade propri = new Propriedade(id,nmpropriedade,nmproprietario,nmemail);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Propriedade> callalt = ServerConnection.getInstance().getService()
                                .alterarFazenda(propri);
                        callalt.enqueue(new Callback<Propriedade>() {
                            @Override
                            public void onResponse(Call<Propriedade> call, Response<Propriedade> response) {

                                try{

                                    if (response.isSuccessful()){

                                        Toast.makeText(getApplicationContext(), "Fazenda"
                                                + response.body().getPropriedade()
                                                +" Alterada!",Toast.LENGTH_SHORT).show();

                                    }else{

                                        Log.e(this.getClass().toString(), "Error on calling" + response.code());

                                    }

                                }catch(Exception e){

                                    Log.e(this.getClass().toString(), e.getMessage().toString());

                                }

                            }

                            @Override
                            public void onFailure(Call<Propriedade> call, Throwable t) {

                                Log.e(this.getClass().toString(), t.getMessage().toString());

                            }
                        });
                    }
                });

            }
        });

        Button banimal = (Button) findViewById(R.id.buttonIrAosAnimais);
        banimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ila = new Intent(PerfilFazendaActivity.this, ListarAnimaisActivity.class);
                startActivity(ila);
                ila.putExtra("Propriedade",etpropriedade.getText().toString());

            }
        });

        preencheredittexts();

    }

    public void preencheredittexts(){
        new Thread(new Runnable() {

            Integer idpropriedade = id;

            @Override
            public void run() {

                Call<List<Propriedade>> call = ServerConnection
                        .getInstance().getService().inserirFazendaid(idpropriedade);

                Log.i(this.getClass().getName(), "Calling list");

                call.enqueue(new Callback<List<Propriedade>>() {

                    @Override
                    public void onResponse(Call<List<Propriedade>> call, Response<List<Propriedade>> response) {

                        try{

                            if(response.isSuccessful()){

                                List<Propriedade> propriRespon = response.body();

                                Propriedade propriedade = propriRespon.get(idpropriedade);

                                etpropriedade.setText(propriedade.getPropriedade().toString());
                                etproprietario.setText(propriedade.getProprietario().toString());
                                etemail.setText(propriedade.getEmail().toString());

                            }else{

                                Log.e(this.getClass().toString(), "Error on Calling");

                            }

                        }catch(Exception e){

                            Log.e(this.getClass().toString(),"Error on Calling");

                        }

                    }

                    @Override
                    public void onFailure(Call<List<Propriedade>> call, Throwable t) {

                        Log.e(this.getClass().toString(),"Error on Calling");

                    }

                });

            }

        }).start();

    }

}
