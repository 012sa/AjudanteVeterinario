package com.example.sarah.vetappfunfando.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sarah.vetappfunfando.R;

public class ListarFazendasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_fazendas);
        FloatingActionButton maddFazenda = (FloatingActionButton) findViewById(R.id.add_fazendas);
        maddFazenda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListarFazendasActivity.this, CadastrarFazendaActivity.class);
                startActivity(i);
            }
        });
    }
}
