package com.example.roloj;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.Calendar;

public class Hora extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Handler handler = new Handler();
    private String mParam1;
    private String mParam2;


    public Hora() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hora, container, false);
        TextView tvHora = view.findViewById(R.id.tvHora);
        TextView tvMin = view.findViewById(R.id.tvMinutos);
        TextView tvSeg = view.findViewById(R.id.tvSegundos);
        Button btnEditar = view.findViewById(R.id.editarHora);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                int hora = calendar.get(Calendar.HOUR_OF_DAY);
                int minuto = calendar.get(Calendar.MINUTE);
                int segundo = calendar.get(Calendar.SECOND);

                // Convertir a String con dos dígitos
                tvHora.setText(String.format("%02d", hora));
                tvMin.setText(String.format("%02d", minuto));
                tvSeg.setText(String.format("%02d", segundo));

                handler.postDelayed(this, 1000); // actualiza cada segundo
            }
        };

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear EditText para hora y minutos
                EditText editHora = new EditText(getContext());
                editHora.setHint("Hora (0-23)");
                EditText editMin = new EditText(getContext());
                editMin.setHint("Minuto (0-59)");

                // Ponerlos en un LinearLayout vertical
                LinearLayout layout = new LinearLayout(getContext());
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(editHora);
                layout.addView(editMin);
                layout.setPadding(50, 40, 50, 10);

                // Crear el AlertDialog
                new AlertDialog.Builder(getContext())
                        .setTitle("Editar la hora")
                        .setView(layout)
                        .setPositiveButton("Aceptar", (dialog, which) -> {
                            String horaStr = editHora.getText().toString();
                            String minStr = editMin.getText().toString();
                            if (!horaStr.isEmpty() && !minStr.isEmpty()) {
                                int hora = Integer.parseInt(horaStr);
                                int min = Integer.parseInt(minStr);
                                // Actualizar TextView
                                tvHora.setText(String.format("%02d", hora));
                                tvMin.setText(String.format("%02d", min));
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();
            }
        });

        handler.post(runnable);

        return view;
    }

}