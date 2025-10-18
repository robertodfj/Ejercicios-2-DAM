package com.example.ej2adivinanza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Juego extends AppCompatActivity {
    int numeroAleatorio;
    int intentos;
    int mejorIntento = Integer.MAX_VALUE;

    int intentoActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnInicio = findViewById(R.id.btnInicio);
        Button btnAjustes = findViewById(R.id.btnAjustes);
        Button btnNuevoIntento = findViewById(R.id.button);
        Button btnAplicar = findViewById(R.id.aplicar);
        EditText editText = findViewById(R.id.editTextText);
        TextView resultado = findViewById(R.id.resultado);
        TextView intentosText = findViewById(R.id.intentos);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Juego.this, Ajustes.class);
                startActivity(i);
            }
        });

        // Seleccion maximos y minimos desde el intent de Ajustes
        Intent intent = getIntent();
        int max, min;
        min = intent.getIntExtra("min", 1);
        max = intent.getIntExtra("max", 10);
        int intentosIniciales = intent.getIntExtra("intentos", 3);

        btnNuevoIntento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroAleatorio = (int) (Math.random() * (max - min +1)) +min;
                intentos = intentosIniciales;
                resultado.setText("");
                editText.setText("");

                intentoActual = 0;

                // Mensaje opcional
                Toast.makeText(Juego.this, "¡Nuevo número generado! Intenta adivinar.", Toast.LENGTH_SHORT).show();
            }
        });
        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numeroEntrada = Integer.parseInt(editText.getText().toString());
                intentoActual++;

                if (numeroEntrada > numeroAleatorio && intentos > 1) {
                    resultado.setText("?<" + numeroEntrada);
                    intentos--;
                } else if (numeroEntrada < numeroAleatorio && intentos > 1) {
                    resultado.setText("?>" + numeroEntrada);
                    intentos--;
                } else if (numeroEntrada == numeroAleatorio) {
                    resultado.setText("CORRECTO!");
                    if (intentoActual < mejorIntento){
                        mejorIntento = intentoActual;
                        Intent i = new Intent(Juego.this, Historial.class);
                        i.putExtra("mejorintento", mejorIntento);
                        startActivity(i);
                        Toast.makeText(Juego.this, "Este es el mejor intento", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Se acabaron los intentos
                    new AlertDialog.Builder(Juego.this)
                            .setTitle("Sin intentos")
                            .setMessage("Crea un nuevo intento para continuar")
                            .setPositiveButton("OK", null)
                            .show();
                }

                intentosText.setText("Intentos: " + intentos);
            }
        });
    }
}