package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaleducacional.R;

import java.util.ArrayList;

import models.Aviso;

public class AvisoAdapter extends
        RecyclerView.Adapter<AvisoAdapter.AvisoHolder>{

    ArrayList<Aviso> avisos = new ArrayList<Aviso>();

    public AvisoAdapter(ArrayList<Aviso> avisos) {
        this.avisos = avisos;
    }

    @NonNull
    @Override
    public AvisoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        View layout =
                layoutInflater.inflate(R.layout.aviso_item_view,
                        parent,
                        false);

        AvisoHolder avisoViewHolder =
                new AvisoHolder(layout);

        return avisoViewHolder;
    }
    @Override
    public int getItemCount() {
        return avisos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AvisoHolder holder, int position) {
        TextView textView =  holder.itemView.findViewById(R.id.txtAvisoView);

        Aviso av = avisos.get(position);

        textView.setText(av.getMensagem());
    }

    public static class AvisoHolder
            extends RecyclerView.ViewHolder{

        public AvisoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
