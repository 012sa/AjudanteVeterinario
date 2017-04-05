package com.example.sarah.vetappfunfando.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sarah.vetappfunfando.R;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bfazendas = (Button) findViewById(R.id.fazendas);
        bfazendas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent ilf = new Intent(MainActivity.this, ListarFazendasActivity.class);
                startActivity(ilf);
            }
        });
        Button btarefasMensais = (Button) findViewById(R.id.tarefasMensais);
        btarefasMensais.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent itm = new Intent(MainActivity.this, TarefasMensaisActivity.class);
                startActivity(itm);
            }
        });
        Button msair = (Button) findViewById(R.id.sair);
        msair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }}