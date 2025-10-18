package com.example.ej2adivinanza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ajustes extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText editIntentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        radioGroup = findViewById(R.id.radioGroup);
        editIntentos = findViewById(R.id.editIntentos);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            int min = 0, max = 10; // por defecto
            int checkedId = radioGroup.getCheckedRadioButtonId();

            if (checkedId == R.id.radioFacil) {
                min = 0;
                max = 10;
            } else if (checkedId == R.id.radioMedia) {
                min = 0;
                max = 25;
            } else if (checkedId == R.id.radioDificil) {
                min = 0;
                max = 100;
            }

            // Validar que el EditText no esté vacío
            String textoIntentos = editIntentos.getText().toString();
            int intentos;
            if (!textoIntentos.isEmpty()) {
                intentos = Integer.parseInt(textoIntentos);
            } else {
                Toast.makeText(this, "Introduce un número de intentos válido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Crear el Intent para pasar los datos a Juego
            Intent i = new Intent(Ajustes.this, Juego.class);
            i.putExtra("min", min);
            i.putExtra("max", max);
            i.putExtra("intentos", intentos);

            Toast.makeText(this, "Ajustes guardados", Toast.LENGTH_SHORT).show();
            startActivity(i);
        });
    }
}