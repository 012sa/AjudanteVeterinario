package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.ajudanteveterinarioandroid.Entity.Animal;
import com.example.sarah.ajudanteveterinarioandroid.Network.ServerConnection;
import com.example.sarah.ajudanteveterinarioandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Integer.parseInt;

public class PerfilAnimalActivity extends AppCompatActivity {

    Integer id;
    List<Animal> listanimal;
    EditText etidade, etnome, etraca, etipo, etsexo, etmae;
    Animal oanimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etidade = (EditText) findViewById(R.id.editTextIdade);
        etnome = (EditText) findViewById(R.id.editTextNome);
        etraca = (EditText) findViewById(R.id.editTextRaca);
        etipo = (EditText) findViewById(R.id.editTextTipo);
        etsexo = (EditText) findViewById(R.id.editTextSexo);
        etmae = (EditText) findViewById(R.id.editTextMae);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        preencheredittexts();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuLA);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent ima = new Intent(PerfilAnimalActivity.this, MainActivity.class);
                startActivity(ima);
            }
        });

        FloatingActionButton fbalterar = (FloatingActionButton) findViewById(R.id.floatingActionButtonAlterarAnimal);
        fbalterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nmnome = etnome.getText().toString();
                final Integer intidade = parseInt(etidade.getText().toString());
                final String nmraca = etraca.getText().toString();
                final String nmtipo = etipo.getText().toString();
                final String nmsexo = etsexo.getText().toString();
                final String nmMae = etmae.getText().toString();

                final Animal anima = new Animal(id,nmnome,intidade, nmraca,nmtipo, nmsexo, nmMae);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Animal> callalt = ServerConnection.getInstance().getService()
                                .alterarAnimal(anima);
                        callalt.enqueue(new Callback<Animal>() {
                            @Override
                            public void onResponse(Call<Animal> call, Response<Animal> response) {

                                try{

                                    if (response.isSuccessful()){

                                        Toast.makeText(getApplicationContext(), "Fazenda"
                                                + response.body().getNome()
                                                +" Alterada!", Toast.LENGTH_SHORT).show();

                                    }else{

                                        Log.e(this.getClass().toString(), "Error on calling" + response.code());

                                    }

                                }catch(Exception e){

                                    Log.e(this.getClass().toString(), e.getMessage().toString());

                                }

                            }

                            @Override
                            public void onFailure(Call<Animal> call, Throwable t) {

                                Log.e(this.getClass().toString(), t.getMessage().toString());

                            }
                        });
                    }
                });

            }
        });

    }
    public void preencheredittexts(){
        new Thread(new Runnable() {

            @Override
            public void run() {

                Call<Animal> callpet = ServerConnection.getInstance().getService()
                        .inserirAnimalid(id);

                Log.i(this.getClass().getName(), "Calling list");

                callpet.enqueue(new Callback<Animal>() {

                    @Override
                    public void onResponse(Call<Animal> call, Response<Animal> response) {
                        try {
                            if (response.isSuccessful()) {
                                List<Animal> animaRespon = (List<Animal>) response.body();

                                Animal animal = animaRespon.get(id);

                                etnome.setText(animal.getNome().toString());
                                etidade.setText(animal.getIdade());
                                etraca.setText(animal.getRaca().toString());
                                etipo.setText(animal.getTipo().toString());
                                etsexo.setText(animal.getSexo().toString());
                                etmae.setText(animal.getMae().toString());
                            } else {
                                Log.e(this.getClass().toString(), "Error on Calling");
                            }
                        }catch (Exception e){
                            Log.e(this.getClass().toString(), "Error on Calling");
                        }
                    }
                    @Override
                    public void onFailure(Call<Animal> call, Throwable t) {
                        Log.e(this.getClass().toString(), "Error on Calling");
                    }
                });

            }

        }).start();

    }
}
