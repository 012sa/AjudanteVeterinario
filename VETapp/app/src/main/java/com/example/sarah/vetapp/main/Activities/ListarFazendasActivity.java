package com.example.sarah.vetapp.main.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sarah.vetapp.R;


public class ListarFazendasActivity extends AppCompatActivity {

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
        ListView lvfazenda = (ListView) findViewById(R.id.listarFazendaListView);
        lvfazenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListarFazendasActivity.this, PerfilFazendaActivity.class);
                startActivity(intent);
            }
        });
    }
}
