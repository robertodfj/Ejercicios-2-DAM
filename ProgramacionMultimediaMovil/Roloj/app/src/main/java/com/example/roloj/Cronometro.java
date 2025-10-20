package com.example.roloj;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cronometro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cronometro extends Fragment {

    private Handler handler = new Handler();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cronometro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cronometro.
     */
    // TODO: Rename and change types and number of parameters
    public static Cronometro newInstance(String param1, String param2) {
        Cronometro fragment = new Cronometro();
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

    private int horas = 0, minutos = 0, segundos = 0;
    private boolean corriendo = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cronometro, container, false);

        Button btnEmpezar = view.findViewById(R.id.empezar);
        Button btnParar = view.findViewById(R.id.Parar);
        Button btnReiniciar = view.findViewById(R.id.Reiniciar);

        TextView tvHora = view.findViewById(R.id.tvHora);
        TextView tvMin = view.findViewById(R.id.tvMinutos);
        TextView tvSeg = view.findViewById(R.id.tvSegundos);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (corriendo) {
                    segundos++;
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                    if (minutos == 60) {
                        minutos = 0;
                        horas++;
                    }

                    tvHora.setText(String.format("%02d", horas));
                    tvMin.setText(String.format("%02d", minutos));
                    tvSeg.setText(String.format("%02d", segundos));
                }
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);

        btnEmpezar.setOnClickListener(v -> corriendo = true);
        btnParar.setOnClickListener(v -> corriendo = false);
        btnReiniciar.setOnClickListener(v -> {
            corriendo = false;
            horas = minutos = segundos = 0;
            tvHora.setText("00");
            tvMin.setText("00");
            tvSeg.setText("00");
        });

        return view;
    }

}