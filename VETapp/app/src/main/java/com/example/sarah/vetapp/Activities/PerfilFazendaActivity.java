package com.example.sarah.vetapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sarah.vetapp.R;

public class PerfilFazendaActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_fazenda);
        FloatingActionButton sair = (FloatingActionButton) findViewById(R.id.floatingActionButtonOut);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itm = new Intent(PerfilFazendaActivity.this, MainActivity.class);
                startActivity(itm);
            }
        });
    }
}
