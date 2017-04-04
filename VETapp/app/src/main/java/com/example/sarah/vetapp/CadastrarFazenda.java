package com.example.sarah.vetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class CadastrarFazenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);
        Button msair = (Button) findViewById(R.id.buttonSair);
        msair.setOnClickListener( new View.onClickListener() {
                                      @Override
                                      public onClick(View v) {
                                          Intent i = new Intent(CadastrarFazenda.this, MainActivity.class);
                                          startActivity(i);
                                      }
        }
        );
    }
}