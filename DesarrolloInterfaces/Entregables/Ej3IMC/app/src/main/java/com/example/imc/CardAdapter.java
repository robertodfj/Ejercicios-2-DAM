package com.example.imc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private ArrayList<CardModel> cardList;
    private Context context;

    // Constructor
    public CardAdapter(Context context, ArrayList<CardModel> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button ver, borrar;
        TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ver = itemView.findViewById(R.id.btnVer);
            borrar = itemView.findViewById(R.id.btnBorrar);
            titulo = itemView.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout de la tarjeta
        View view = LayoutInflater.from(context).inflate(R.layout.card_imc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        CardModel card = cardList.get(position);
        holder.titulo.setText(card.getTitulo());

        // Botón Ver
        holder.ver.setOnClickListener(v -> {
            AlertDialog.Builder alerta = new AlertDialog.Builder(context);
            String name = cardList.get(position).getTitulo();
            alerta.setTitle("Vista de " +name);
        });

        // Botón Borrar
        holder.borrar.setOnClickListener(v -> {
            int pos = holder.getBindingAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                cardList.remove(pos);
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}