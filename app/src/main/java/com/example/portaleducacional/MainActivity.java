package com.example.portaleducacional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import adapters.AvisoAdapter;
import models.Aviso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Tela de inicialização
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //Comportamento da view que foi instanciado antes
        Button buttonAvisos = findViewById(R.id.btnAvisos);
        buttonAvisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        AvisoPage.class);
                startActivity(intent);
            }
        });

        Button buttonMensagens = findViewById(R.id.btnMensagens);
        buttonMensagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        MensagemPage.class);

                startActivity(intent);
            }
        });
    }
}