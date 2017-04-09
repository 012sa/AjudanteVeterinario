package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sarah.ajudanteveterinarioandroid.R;

import butterknife.BindView;

public class CadastrarFazendaActivity extends AppCompatActivity {

    @BindView(R.id.floatingActionButtonAdicionarFazenda) FloatingActionButton fbaddfazenda;
    @BindView(R.id.floatingActionButtonVoltarMenuCF) FloatingActionButton fbvoltarmenu;
    //@BindView(R.id.);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_fazenda);

        fbvoltarmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ivm = new Intent(CadastrarFazendaActivity.this, MainActivity.class);
                startActivity(ivm);
            }
        });

        fbaddfazenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codico para --> add no banco
                //a fazenda
                Intent ivlf = new Intent(CadastrarFazendaActivity.this, ListarFazendaActivity.class);
                startActivity(ivlf);
            }
        });

    }
}
