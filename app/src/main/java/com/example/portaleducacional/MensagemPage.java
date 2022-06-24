package com.example.portaleducacional;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import adapters.AvisoAdapter;
import adapters.MensagemAdapter;
import models.Aviso;
import models.Mensagem;
import services.FirebaseService;

public class MensagemPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mensagens");

        FirebaseService service = new FirebaseService(this);

        Button buttonEnviarMensagem = findViewById(R.id.btnEnviarMsg);

        buttonEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtView = findViewById(R.id.txtMensagem2);

                String text = txtView.getText().toString();

                Mensagem mensagem = new Mensagem(1, text, "");
                service.AdicionarMensagem(mensagem);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMensagens);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        ArrayList<Mensagem> mensagens = service.GetMensagens();

        MensagemAdapter mensagemListAdapter = new MensagemAdapter(mensagens);
        recyclerView.setAdapter(mensagemListAdapter);

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

}