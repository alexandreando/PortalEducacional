package adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaleducacional.MensagemPage;
import com.example.portaleducacional.R;

import java.util.ArrayList;

import models.Mensagem;

public class MensagemAdapter extends
        RecyclerView.Adapter<MensagemAdapter.MensagemHolder>{

    ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

    public MensagemAdapter(ArrayList<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    @NonNull
    @Override
    public MensagemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        View layout =
                layoutInflater.inflate(R.layout.mensagem_item_view,
                        parent,
                        false);

        MensagemHolder userViewHolder = new MensagemHolder(layout);

        return userViewHolder;
    }
    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MensagemHolder holder, int position) {
        Mensagem av = mensagens.get(position);

        if(av != null){
            TextView textView =  holder.itemView.findViewById(R.id.textViewMensagem);
            textView.setText(av.getMensagem());

            ImageView imageView = holder.itemView.findViewById(R.id.imageViewMensagem);
            int userId = av.getUserId();
            if(userId == 1){
                imageView.setImageResource(R.drawable.person1);
            }
            else if(userId == 2){
                imageView.setImageResource(R.drawable.person2);
            }
        }
    }

    public static class MensagemHolder
            extends RecyclerView.ViewHolder{

        public MensagemHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
