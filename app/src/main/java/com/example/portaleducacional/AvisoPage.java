package com.example.portaleducacional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import adapters.AvisoAdapter;
import models.Aviso;

public class AvisoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Avisos");

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAvisos);

        ArrayList<Aviso> avisos = getAvisos();

        AvisoAdapter avisoListAdapter = new AvisoAdapter(avisos);
        recyclerView.setAdapter(avisoListAdapter);

        LinearLayoutManager linearLayoutManager =
            new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private ArrayList<Aviso> getAvisos(){
        ArrayList<Aviso> avisos = new ArrayList<Aviso>();

        avisos.add(new Aviso("Nâo se esqueçam da semana de prova!"));
        avisos.add(new Aviso("A entrega do trabalho será dia 29/04"));
        avisos.add(new Aviso("Não teremos aula nos dias em abril"));
        avisos.add(new Aviso("Mensagem de teste"));

        return avisos;
    }
}