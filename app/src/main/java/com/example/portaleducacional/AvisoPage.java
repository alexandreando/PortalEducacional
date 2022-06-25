package com.example.portaleducacional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import adapters.AvisoAdapter;
import models.Aviso;
import models.Mensagem;

public class AvisoPage extends AppCompatActivity {

    private ArrayList<Aviso> avisos;
    private FirebaseFirestore _db;
    private AvisoAdapter avisoListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Avisos");

        _db = FirebaseFirestore.getInstance();
        avisos = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAvisos);

        avisoListAdapter = new AvisoAdapter(avisos);
        recyclerView.setAdapter(avisoListAdapter);

        LinearLayoutManager linearLayoutManager =
            new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        getAvisos();
    }

    private void getAvisos() {
        avisos.clear();
        _db.collection("avisos").orderBy("Criado", Query.Direction.DESCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Aviso c = d.toObject(Aviso.class);

                                avisos.add(c);
                            }
                            avisoListAdapter.notifyDataSetChanged();
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