package com.example.sarah.vetajudanteveterinarioandroid.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.vetajudanteveterinarioandroid.R;
import com.example.sarah.vetajudanteveterinarioandroid.entity.Propriedade;
import com.example.sarah.vetajudanteveterinarioandroid.network.ConnectionServer;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;
import static java.lang.Integer.parseInt;

public class PerfilFazendaActivity extends AppCompatActivity {

    String proprieda;
    @BindView(R.id.edittextPropriedadePF) EditText etpropriedade;
    @BindView(R.id.edittextProprietarioPF) EditText etproprietario;
    @BindView(R.id.edittextEmailPF) EditText etemail;
    @BindView(R.id.floatingActionButtonVoltarMenuPF) FloatingActionButton fbvoltarmenu;
    @BindView(R.id.floatingActionButtonAlterar) FloatingActionButton fbalterar;
    @BindView(R.id.buttonIrAosAnimais) Button banimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_fazenda);

        Intent intent= getIntent();
        final Integer id = Integer.parseInt(intent.getStringExtra("id"));

        preencheredittexts();

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ima = new Intent(PerfilFazendaActivity.this, MainActivity.class);
                startActivity(ima);
            }
        });

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
                        Call<Propriedade> callalt = ConnectionServer.getInstance().getService()
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


        banimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                proprieda = etpropriedade.getText().toString();
                Intent ila = new Intent(PerfilFazendaActivity.this, ListarAnimaisActivity.class);
                startActivity(ila);
                ila.putExtra("Propriedadeid",proprieda);

            }
        });

    }
    public void preencheredittexts() {
        new Thread(new Runnable() {

            Integer idpropriedade = id;

            @Override
            public void run() {

                Call<List<Propriedade>> call = ConnectionServer
                        .getInstance().getService().inserirFazendaid(idpropriedade);

                Log.i(this.getClass().getName(), "Calling list");

                call.enqueue(new Callback<List<Propriedade>>() {

                    @Override
                    public void onResponse(Call<List<Propriedade>> call, Response<List<Propriedade>> response) {

                        try {

                            if (response.isSuccessful()) {

                                List<Propriedade> propriRespon = response.body();

                                Propriedade propriedade = propriRespon.get(idpropriedade);

                                etpropriedade.setText(propriedade.getPropriedade().toString());
                                etproprietario.setText(propriedade.getProprietario().toString());
                                etemail.setText(propriedade.getEmail().toString());

                            } else {

                                Log.e(this.getClass().toString(), "Error on Calling");

                            }

                        } catch (Exception e) {

                            Log.e(this.getClass().toString(), "Error on Calling");

                        }

                    }

                    @Override
                    public void onFailure(Call<List<Propriedade>> call, Throwable t) {

                        Log.e(this.getClass().toString(), "Error on Calling");

                    }

                });

            }

        }).start();
    }
}
