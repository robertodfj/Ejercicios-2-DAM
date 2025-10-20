package com.example.roloj;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
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

import java.util.Calendar;

public class Alarma extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    // Variables de alarma
    private boolean alarmaActiva = false;
    private int horaAlarma = 0;
    private int minutoAlarma = 0;

    private Handler handler = new Handler();

    public Alarma() {
        // Constructor vacío
    }

    public static Alarma newInstance(String param1, String param2) {
        Alarma fragment = new Alarma();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alarma, container, false);

        TextView tvHora = view.findViewById(R.id.tvHora);
        TextView tvMin = view.findViewById(R.id.tvMinutos);
        TextView tvSeg = view.findViewById(R.id.tvSegundos);
        Button btnAñadir = view.findViewById(R.id.añadirAlarma);
        Button btnQuitar = view.findViewById(R.id.quitarAlarma);

        // Runnable que comprueba la hora cada segundo
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alarmaActiva) {
                    Calendar calendar = Calendar.getInstance();
                    int horaActual = calendar.get(Calendar.HOUR_OF_DAY);
                    int minutoActual = calendar.get(Calendar.MINUTE);

                    // Actualizamos el TextView con la hora de la alarma
                    tvHora.setText(String.format("%02d", horaAlarma));
                    tvMin.setText(String.format("%02d", minutoAlarma));

                    // Si la hora coincide, reproducimos el sonido
                    if (horaAlarma == horaActual && minutoAlarma == minutoActual) {
                        try {
                            Uri alarmaUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                            if (alarmaUri == null) {
                                alarmaUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            }
                            Ringtone ringtone = RingtoneManager.getRingtone(getContext(), alarmaUri);
                            ringtone.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // Para que suene solo una vez hasta que se desactive
                        alarmaActiva = false;
                    }
                }

                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);

        // Botón añadir alarma
        btnAñadir.setOnClickListener(v -> {
            EditText editHora = new EditText(getContext());
            editHora.setHint("Hora (0-23)");
            EditText editMin = new EditText(getContext());
            editMin.setHint("Minuto (0-59)");

            LinearLayout layout = new LinearLayout(getContext());
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(editHora);
            layout.addView(editMin);
            layout.setPadding(50, 40, 50, 10);

            new AlertDialog.Builder(getContext())
                    .setTitle("Añade una alarma")
                    .setView(layout)
                    .setPositiveButton("Aceptar", (dialog, which) -> {
                        String horaStr = editHora.getText().toString();
                        String minStr = editMin.getText().toString();
                        if (!horaStr.isEmpty() && !minStr.isEmpty()) {
                            horaAlarma = Integer.parseInt(horaStr);
                            minutoAlarma = Integer.parseInt(minStr);
                            alarmaActiva = true;

                            tvHora.setText(String.format("%02d", horaAlarma));
                            tvMin.setText(String.format("%02d", minutoAlarma));
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });

        // Botón quitar alarma
        btnQuitar.setOnClickListener(v -> alarmaActiva = false);

        return view;
    }
}