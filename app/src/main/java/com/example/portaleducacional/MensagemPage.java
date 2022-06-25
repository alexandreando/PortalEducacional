package com.example.portaleducacional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import adapters.AvisoAdapter;
import adapters.MensagemAdapter;
import adapters.MensagemAdapter2;
import models.Aviso;
import models.Mensagem;
import services.FirebaseService;

public class MensagemPage extends AppCompatActivity {

    FirebaseFirestore _db;
    ArrayList<Mensagem> mensagens;
    RecyclerView recyclerView;
    MensagemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mensagens");

        //Inicializadores
        _db = FirebaseFirestore.getInstance();
        mensagens = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewMensagens);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MensagemAdapter(mensagens, this);
        recyclerView.setAdapter(adapter);

        //Adicionar
        FirebaseService service = new FirebaseService(this);
        Button buttonEnviarMensagem = findViewById(R.id.btnEnviarMsg);
        buttonEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtView = findViewById(R.id.txtMensagem2);

                String text = txtView.getText().toString();

                Mensagem mensagem = new Mensagem(1, text, "");
                service.AdicionarMensagem(mensagem);

                txtView.setText("");
                getMensagens();
            }
        });

        //retrieve direto
        getMensagens();
    }

    private void getMensagens() {
        mensagens.clear();
        _db.collection("mensagens").orderBy("Criado", Query.Direction.DESCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Mensagem c = d.toObject(Mensagem.class);

                                mensagens.add(c);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
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