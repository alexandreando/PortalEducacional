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
import android.widget.Button;
import android.widget.TextView;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mensagens");

        Button buttonEnviarMensagem = findViewById(R.id.btnEnviarMsg);

        buttonEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtView = findViewById(R.id.txtMensagem2);

                String text = txtView.getText().toString();

                if(text != null && !text.isEmpty()){
                    txtView.setText("");

                    new AlertDialog.Builder(MensagemPage.this)
                            .setTitle("Mensagem enviada!")
                            .setMessage("Sua mensagem está sendo processada :)")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                }
                            })
                            .setIcon(R.drawable.message)
                            .show();
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMensagens);

        ArrayList<Mensagem> mensagens = getMensagens();

        MensagemAdapter mensagemListAdapter = new MensagemAdapter(mensagens);
        recyclerView.setAdapter(mensagemListAdapter);

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

    private ArrayList<Mensagem> getMensagens(){
        ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

        mensagens.add(new Mensagem(1,"Mensagem 1", ""));
        mensagens.add(new Mensagem(2,"Mensagem 2", ""));
        mensagens.add(new Mensagem(1,"Mensagem 3", ""));
        mensagens.add(new Mensagem(2,"AAAAAAAAAAAAAA", ""));

        return mensagens;
    }
}