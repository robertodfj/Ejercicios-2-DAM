package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Editar extends AppCompatActivity {

    ArrayList<CardModel> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText titulo = findViewById(R.id.editTitulo);
        EditText peso = findViewById(R.id.editPeso);
        EditText altura = findViewById(R.id.editTextText3);

        CardModel card = (CardModel) getIntent().getSerializableExtra("card");

        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(v -> {
            card.setTitulo(titulo.getText().toString());
            card.setPesoKG(Float.parseFloat(peso.getText().toString()));
            card.setAltura(Float.parseFloat(altura.getText().toString()));
            // Calcula nuevo IMC
            float imc = card.getPesoKG() / (card.getAltura() * card.getAltura());
            card.setResultadoIMC(imc);

            Intent intent = new Intent();
            intent.putExtra("card", card);
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}