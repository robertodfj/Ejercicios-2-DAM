package com.example.imc;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CardModel> cardList;
    CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mejor usar getSupportActionBar() en lugar de getActionBar()
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        Button añadir = findViewById(R.id.btnNuevo);
        recyclerView = findViewById(R.id.reciclerView);
        cardList = new ArrayList<>();
        cardAdapter = new CardAdapter(this, cardList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cardAdapter);

        añadir.setOnClickListener(v -> {
            // Crear los EditText
            EditText titulo = new EditText(MainActivity.this);
            titulo.setHint("Añade aquí el nombre");

            EditText peso = new EditText(MainActivity.this);
            peso.setHint("Añade aquí el peso en KG");
            peso.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

            EditText altura = new EditText(MainActivity.this);
            altura.setHint("Añade aquí la altura en metros");
            altura.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

            // Crear un layout
            LinearLayout layout = new LinearLayout(MainActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            int padding = (int) getResources().getDisplayMetrics().density * 16;
            layout.setPadding(padding, padding, padding, padding);
            layout.addView(titulo);
            layout.addView(peso);
            layout.addView(altura);

            // Crear el diálogo
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setTitle("Añade una nueva medición IMC");
            alerta.setView(layout);

            alerta.setPositiveButton("Guardar", (dialog, which) -> {
                String nombre = titulo.getText().toString();
                float pesoValor = Float.parseFloat(peso.getText().toString());
                float alturaValor = Float.parseFloat(altura.getText().toString());

                float resultado = pesoValor / (alturaValor * alturaValor);

                cardList.add(new CardModel(nombre, pesoValor, alturaValor, resultado));
                cardAdapter.notifyItemInserted(cardList.size() -1);

                Toast.makeText(MainActivity.this, "IMC de " + nombre + ": " + resultado, Toast.LENGTH_LONG).show();
            });

            alerta.setNegativeButton("Cancelar", null);
            alerta.show();
        });
    }
}