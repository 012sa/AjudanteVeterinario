package com.example.sarah.vetapp.main.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sarah.vetapp.R;
import com.example.sarah.vetapp.main.Entity.Fazenda;

public class CadastrarFazendaActivity extends Activity {

    private EditText propriedade;
    private EditText proprietario;
    private EditText emailProprietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);
        propriedade = (EditText) findViewById(R.id.nomeFazenda);
        proprietario = (EditText) findViewById(R.id.nomeProprietario);
        emailProprietario = (EditText) findViewById(R.id.emailProprietario);
        Button bsair = (Button) findViewById(R.id.buttonSair);
        bsair.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent i = new Intent(CadastrarFazendaActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        Button badd = (Button) findViewById(R.id.add_fazenda);
        badd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String proprieta = proprietario.toString();
                String proprieda = propriedade.toString();
                String email = emailProprietario.toString();
                Fazenda fazenda = new Fazenda(proprieda,proprieta,email);

            }
        });

    }



}