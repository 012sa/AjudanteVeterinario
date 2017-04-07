package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.app.ListActivity;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sarah.ajudanteveterinarioandroid.R;

public class ListarFazendaActivity extends ListActivity {

    public Integer idfazenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_fazenda);

        FloatingActionButton fbaddfazenda = (FloatingActionButton) findViewById(R.id.floatingActionButtonAddFazenda);
        fbaddfazenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent icf = new Intent(ListarFazendaActivity.this, CadastrarFazendaActivity.class);
                startActivity(icf);

            }
        });

        FloatingActionButton fbvoltarmenu = (FloatingActionButton) findViewById(R.id.floatingActionButtonVoltarMenuLF);
        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ima = new Intent(ListarFazendaActivity.this, MainActivity.class);
                startActivity(ima);

            }
        });

        ListView listView = getListView(); // hear bind your listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
                Intent ipfa = new Intent(ListarFazendaActivity.this, PerfilFazendaActivity.class);
                startActivity(ipfa);
                idfazenda = (int) itemId;
            }
        });

    }
}
