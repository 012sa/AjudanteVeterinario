package com.example.sarah.ajudanteveterinarioandroid.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sarah.ajudanteveterinarioandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttontarefasmensais = (Button) findViewById(R.id.irTarefa);
        buttontarefasmensais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itm = new Intent(MainActivity.this, TarefasMensaisActivity.class);
                startActivity(itm);
            }
        });

        Button bfazendas = (Button) findViewById(R.id.irFazenda);
        bfazendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFarm = new Intent(MainActivity.this, ListarFazendaActivity.class);
                startActivity(iFarm);
            }
        });

        FloatingActionButton saida = (FloatingActionButton) findViewById(R.id.floatingActionButtonSair);
        saida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }
}
