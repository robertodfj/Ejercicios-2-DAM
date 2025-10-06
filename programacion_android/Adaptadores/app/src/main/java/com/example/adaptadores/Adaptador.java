package com.example.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter {

    Pokemon[] datos;

    public Adaptador(@NonNull Context context, Pokemon[] informacion) {
        super(context, R.layout.vista_elemento, informacion);
        this.datos = informacion;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflador = LayoutInflater.from(getContext());
        View elemento = inflador.inflate(R.layout.vista_elemento, parent, false);

        TextView nombre = elemento.findViewById(R.id.nombre);
        nombre.setText(datos[position].getNombre());

        TextView id = elemento.findViewById(R.id.id);
        id.setText("#00" + datos[position].getId());

        TextView tipo = elemento.findViewById(R.id.tipo);
        tipo.setText("Tipo: " + datos[position].getTipo());

        ImageView icono = elemento.findViewById(R.id.imageView);
        LinearLayout fondo = elemento.findViewById(R.id.fondo);



        switch (datos[position].getTipo()){
            case "Fuego" : icono.setImageResource(R.drawable.fuego); fondo.setBackgroundResource(R.drawable.degradado_rojo); break;
            case "Agua" : icono.setImageResource(R.drawable.agua); fondo.setBackgroundResource(R.drawable.degradado_azul); break;
            case "Planta" : icono.setImageResource(R.drawable.planta); fondo.setBackgroundResource(R.drawable.degradado_verde); break;
        }

        return elemento;
    }
}