package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaleducacional.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import models.Mensagem;

public class MensagemAdapter2 extends FirebaseRecyclerAdapter<
        Mensagem, MensagemAdapter2.personsViewholder> {

    public MensagemAdapter2(
            @NonNull FirebaseRecyclerOptions<Mensagem> options)
    {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull Mensagem model)
    {
        holder.mensagem.setText(model.getMensagem());
    }

    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_mensagem_page, parent, false);
        return new MensagemAdapter2.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView mensagem;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            mensagem = itemView.findViewById(R.id.textViewMensagem);
        }
    }
}
