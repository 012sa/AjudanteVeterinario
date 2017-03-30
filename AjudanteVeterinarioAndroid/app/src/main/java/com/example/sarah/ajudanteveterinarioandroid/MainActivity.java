package com.example.sarah.ajudanteveterinarioandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mfazendas = (Button) findViewById(R.id.fazendas);
        mfazendas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListarFazendas.class);
                startActivity(i);
            }
        });
        Button mtarefasMensais = (Button) findViewById(R.id.tarefasMensais);
        mtarefasMensais.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TarefasMensais.class);
                startActivity(i);
            }
        });
        Button msair = (Button) findViewById(R.id.sair);
        mfazendas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onDestroy();
            }
        });
    }
}
