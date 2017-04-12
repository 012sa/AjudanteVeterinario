package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.ajudanteveterinarioandroid.Entity.Propriedade;
import com.example.sarah.ajudanteveterinarioandroid.Network.ServerConnection;
import com.example.sarah.ajudanteveterinarioandroid.R;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;

public class CadastrarFazendaActivity extends AppCompatActivity {

    @BindView(R.id.floatingActionButtonAdicionarFazenda) FloatingActionButton fbaddfazenda;
    @BindView(R.id.floatingActionButtonVoltarMenuCF) FloatingActionButton fbvoltarmenu;
    @BindView(R.id.edittextProprietario) EditText etproprietario;
    @BindView(R.id.edittextPropriedade) EditText etpropriedade;
    @BindView(R.id.edittextEmail) EditText etemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ivm = new Intent(CadastrarFazendaActivity.this, MainActivity.class);
                startActivity(ivm);
            }
        });

        fbaddfazenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ivlf = new Intent(CadastrarFazendaActivity.this, ListarFazendaActivity.class);
                startActivity(ivlf);
                final String propriedade, proprietario, email;

                propriedade = etpropriedade.getText().toString();
                proprietario = etproprietario.getText().toString();
                email = etemail.getText().toString();
                final Propriedade fazenda = new Propriedade(id, propriedade,proprietario,email);

                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        Call<Propriedade> call = ServerConnection.getInstance().getService().inserirFazenda(fazenda);

                        call.enqueue(new Callback<Propriedade>() {
                            @Override
                            public void onResponse(Call<Propriedade> call, Response<Propriedade> response) {
                                try{

                                    if (response.isSuccessful()) {

                                        Toast.makeText(getApplicationContext(), "Propriedade " +
                                                        response.body().getPropriedade() +
                                                        " cadastrada!"
                                                ,Toast.LENGTH_SHORT).show();

                                        Intent icfa = new Intent(CadastrarFazendaActivity.this, ListarFazendaActivity.class);
                                        startActivity(icfa);
                                    }else{
                                        Log.e(this.getClass().toString(), "Error on calling"+response.code());
                                    }

                                }catch (Exception e){
                                    Log.e(this.getClass().toString(),e.getMessage().toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<Propriedade> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Conexão falhou", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
