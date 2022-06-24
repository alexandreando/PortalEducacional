package services;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.portaleducacional.MensagemPage;
import com.example.portaleducacional.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Mensagem;

public class FirebaseService {
    private FirebaseFirestore _db;
    private Context _context;
    private ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

    public FirebaseService(Context context){
        _context = context;
        _db = FirebaseFirestore.getInstance();
    }

    public void AdicionarMensagem(Mensagem mensagem){
        Map<String,Object> hashMensagem = new HashMap<>();
        hashMensagem.put("Mensagem", mensagem.getMensagem());
        hashMensagem.put("UserId", mensagem.getUserId());
        hashMensagem.put("CriadoEm", mensagem.getCriadoEm());
        hashMensagem.put("Foto", mensagem.getFoto());

        _db.collection("mensagens")
                .add(hashMensagem)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        new AlertDialog.Builder(_context)
                                .setTitle("Sucesso!")
                                .setMessage("Sua mensagem foi enviada:)")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Continue with delete operation
                                    }
                                })
                                .setIcon(R.drawable.message)
                                .show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public ArrayList<Mensagem> GetMensagens(){
        readData(new FIrestoreCallback() {
            @Override
            public void onCallback(List<Mensagem> lista) {
                mensagens.addAll(lista);
            }
        });


        return mensagens;
    }

    private void readData(FIrestoreCallback fIrestoreCallback){
        _db.collection("mensagens")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Mensagem m = document.toObject(Mensagem.class);
                                //String msg = document.getString("Mensagem");
                                //Mensagem m = new Mensagem();
                                //m.setMensagem(msg);
                                mensagens.add(m);
                            }
                            fIrestoreCallback.onCallback(mensagens);
                        } else {
                        }
                    }
                });
    }

    private interface FIrestoreCallback{
        void onCallback(List<Mensagem> mensagens);
    }
}
