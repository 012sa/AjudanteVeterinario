package com.example.sarah.vetajudanteveterinarioandroid.activity;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import com.example.sarah.vetajudanteveterinarioandroid.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    //@BindView (R.id.irFazendaMA) Button bfazendas;
    //@BindView(R.id.floatingActionButtonSairMA) FloatingActionButton fbsair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bfazendas= (Button) findViewById(R.id.irFazendaMA);
        bfazendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iFarm = new Intent(MainActivity.this, ListarFazendaActivity.class);
                startActivity(iFarm);
            }
        });
        FloatingActionButton fbsair = (FloatingActionButton) findViewById(R.id.floatingActionButtonSairMA);
        fbsair.setOnClickListener(new View.OnClickListener() {
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
