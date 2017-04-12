package com.example.sarah.ajudanteveterinarioandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sarah.ajudanteveterinarioandroid.R;

public class ListarAnimaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_animais);

        Intent inte = getIntent();
        Bundle b = inte.getExtras();
        

    }
}
