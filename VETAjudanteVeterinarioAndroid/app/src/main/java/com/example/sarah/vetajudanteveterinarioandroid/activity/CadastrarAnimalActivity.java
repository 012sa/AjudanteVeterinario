package com.example.sarah.vetajudanteveterinarioandroid.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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

public class CadastrarAnimalActivity extends AppCompatActivity {

    @BindView(R.id.editTextNomeCA) EditText etnome;
    @BindView(R.id.editTextRacaCA) EditText etraca;
    @BindView(R.id.editTextIdadeCA) EditText etidade;
    @BindView(R.id.editTextTipoCA) EditText ettipo;
    @BindView(R.id.editTextSexoCA) EditText etsexo;
    @BindView(R.id.editTextMaeCA) EditText etmae;
    @BindView(R.id.editTextClassificacaoCA) EditText etcalssificacao;
    List<Animal> listanimal;
    String propriedadenm;
    Animal animal;
    @BindView(R.id.floatingActionButtonCadastrarAnimalCA) FloatingActionButton fbaddanimal;
    @BindView(R.id.floatingActionButtonVoltarMenuCA) FloatingActionButton fbvoltarmenu;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_animal);
        Intent intent = getIntent();
        propriedadenm = intent.getStringExtra("propriedade");
        
        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ima = new Intent(CadastrarAnimalActivity.this, MainActivity.class);
                startActivity(ima);
            }
        });
        
        fbaddanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ilaa = new Intent(CadastrarAnimalActivity.this, ListarAnimaisActivity.class);
                startActivity(ilaa);
                
                final String nome, raca, idade, tipo, sexo, mae, classificacao;
                nome = etnome.getText().toString();
                raca = etraca.getText().toString();
                idade = etidade.getText().toString();
                tipo = ettipo.getText().toString();
                sexo = etsexo.getText().toString();
                mae = etmae.getText().toString();
                classificacao = etcalssificacao.getText().toString();
                final Animal anima = new Animal(nome,raca,idade,tipo,sexo,mae,classificacao,propriedadenm);
                
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Call<Animal> call = ConnectionServer.getInstance().getService().inserirAnimal(anima);
                        call.enqueue(new Callback<Animal>() {
                            @Override
                            public void onResponse(Call<Animal> call, Response<Animal> response) {
                                try{

                                    if (response.isSuccessful()) {

                                        Toast.makeText(getApplicationContext(), "Animal" +
                                                        response.body().getNome() +
                                                        " cadastrada!"
                                                ,Toast.LENGTH_SHORT).show();
                                        
                                    }else{
                                        Log.e(this.getClass().toString(), "Error on calling"+response.code());
                                    }

                                }catch (Exception e){
                                    Log.e(this.getClass().toString(),e.getMessage().toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<Animal> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Conexão falhou", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
        
    }
}
