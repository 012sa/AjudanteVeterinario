package com.example.sarah.vetapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sarah.vetapp.R;

public class CadastrarFazendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);
        final Button bsair = (Button) findViewById(R.id.buttonSair);
        bsair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CadastrarFazendaActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}