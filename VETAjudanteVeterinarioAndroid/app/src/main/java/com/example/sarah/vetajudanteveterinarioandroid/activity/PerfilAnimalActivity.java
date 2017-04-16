package com.example.sarah.vetajudanteveterinarioandroid.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.vetajudanteveterinarioandroid.R;
import com.example.sarah.vetajudanteveterinarioandroid.entity.Animal;
import com.example.sarah.vetajudanteveterinarioandroid.network.ConnectionServer;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Integer.parseInt;

public class PerfilAnimalActivity extends AppCompatActivity {

    Integer idanimal;
    String nmpropriedade;
    @BindView(R.id.editTextIdadeCA) EditText etidade;
    @BindView (R.id.editTextNomeCA) EditText etnome;
    @BindView (R.id.editTextRacaCA) EditText etraca;
    @BindView (R.id.editTextTipoCA) EditText etipo;
    @BindView(R.id.editTextClassificacaoCA) EditText etclassificacao;
    @BindView (R.id.editTextSexoCA) EditText etsexo;
    @BindView (R.id.editTextMaeCA) EditText etmae;
    @BindView(R.id.floatingActionButtonVoltarMenuPA) FloatingActionButton fbvoltarmenu;
    @BindView(R.id.floatingActionButtonAlterarAnimal) FloatingActionButton fbalterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_animal);
        Intent intent = getIntent();
        idanimal=Integer.parseInt(intent.getStringExtra("id"));
        nmpropriedade = intent.getStringExtra("propriedade");

        preencheredittexts();

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ima = new Intent(PerfilAnimalActivity.this, MainActivity.class);
                startActivity(ima);
            }
        });

        fbalterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nmnome = etnome.getText().toString();
                final Integer intidade = parseInt(etidade.getText().toString());
                final String nmraca = etraca.getText().toString();
                final String nmtipo = etipo.getText().toString();
                final String nmsexo = etsexo.getText().toString();
                final String nmmae = etmae.getText().toString();
                final String nmclassificacao =etclassificacao.getText().toString();

                final Animal anima = new Animal(idanimal, nmraca, nmclassificacao, nmmae, nmtipo,
                        nmsexo, nmnome, intidade,nmpropriedade);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Animal> callalt = ConnectionServer.getInstance().getService()
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

                Call<Animal> callpet = ConnectionServer.getInstance().getService().Animalid(idanimal);

                Log.i(this.getClass().getName(), "Calling list");

                callpet.enqueue(new Callback<Animal>() {

                    @Override
                    public void onResponse(Call<Animal> call, Response<Animal> response) {
                        try {
                            if (response.isSuccessful()) {
                                List<Animal> animaRespon = (List<Animal>) response.body();

                                Animal animal = animaRespon.get(idanimal);

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



