package com.example.sarah.vetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;


public class ListarFazendas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_fazendas);
        FloatingActionButton maddFazenda = (FloatingActionButton) findViewById(R.id.add_fazendas);
        maddFazenda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListarFazendas.this, CadastrarFazenda.class);
                startActivity(i);
            }
        });
    }
}
