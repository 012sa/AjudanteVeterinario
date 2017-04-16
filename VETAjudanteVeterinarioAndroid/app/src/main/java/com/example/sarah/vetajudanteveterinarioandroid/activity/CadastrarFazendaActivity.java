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
import com.example.sarah.vetajudanteveterinarioandroid.entity.Propriedade;
import com.example.sarah.vetajudanteveterinarioandroid.network.ConnectionServer;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;

public class CadastrarFazendaActivity extends AppCompatActivity {

    //@BindView(R.id.floatingActionButtonAdicionarFazenda) FloatingActionButton fbaddfazenda;
    FloatingActionButton fbaddfazenda = (FloatingActionButton) findViewById(R.id.floatingActionButtonAdicionarFazenda);
    //@BindView(R.id.floatingActionButtonVoltarMenuCF) FloatingActionButton fbvoltarmenu;
    FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuCF);
    //@BindView(R.id.edittextProprietario) EditText etproprietario;
    EditText etproprietario = (EditText) findViewById(R.id.edittextProprietario);
    //@BindView(R.id.edittextPropriedade) EditText etpropriedade;
    EditText etpropriedade = (EditText) findViewById(R.id.edittextPropriedade);
    //@BindView(R.id.edittextEmail) EditText etemail;
    EditText etemail = (EditText) findViewById(R.id.edittextEmail);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ima = new Intent(CadastrarFazendaActivity.this, MainActivity.class);
                startActivity(ima);
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
                        Call<Propriedade> call = ConnectionServer.getInstance().getService().inserirFazenda(fazenda);

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
