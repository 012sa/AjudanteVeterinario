package com.example.sarah.vetappfunfando.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sarah.vetappfunfando.R;

public class CadastrarFazendaActivity extends Activity {

    //private EditText propriedade;
    //private EditText proprietario;
   // private EditText emailProprietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);
     //   propriedade = (EditText) findViewById(R.id.nomeFazenda);
       // proprietario = (EditText) findViewById(R.id.nomeProprietario);
        //emailProprietario = (EditText) findViewById(R.id.emailProprietario);
        Button bsair = (Button) findViewById(R.id.buttonSair);
        bsair.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent i = new Intent(CadastrarFazendaActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
}}
