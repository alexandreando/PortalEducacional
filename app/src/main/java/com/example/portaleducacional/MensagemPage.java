package com.example.portaleducacional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import adapters.AvisoAdapter;
import adapters.MensagemAdapter;
import models.Aviso;
import models.Mensagem;

public class MensagemPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_page);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMensagens);

        ArrayList<Mensagem> mensagens = getMensagens();

        MensagemAdapter mensagemListAdapter = new MensagemAdapter(mensagens);
        recyclerView.setAdapter(mensagemListAdapter);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private ArrayList<Mensagem> getMensagens(){
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

        mensagens.add(new Mensagem("Mensagem 1", ""));
        mensagens.add(new Mensagem("Mensagem 2", ""));
        mensagens.add(new Mensagem("Mensagem 3", ""));
        mensagens.add(new Mensagem("AAAAAAAAAAAAAA", ""));

        return mensagens;
    }
}