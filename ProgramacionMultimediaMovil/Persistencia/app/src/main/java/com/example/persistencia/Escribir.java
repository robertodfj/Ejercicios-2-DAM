package com.example.persistencia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Escribir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_escribir);

        Button guardar = (Button) findViewById(R.id.guardar);
        Button volver = (Button) findViewById(R.id.volver);

        EditText editTitulo = (EditText) findViewById(R.id.editTitulo);
        EditText editContenido = (EditText) findViewById(R.id.editContenido);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = editTitulo.getText().toString().trim();
                String contenido = editContenido.getText().toString();
                if (titulo.isEmpty()){
                    Toast.makeText(Escribir.this, "El titulo no puede estar vacio", Toast.LENGTH_SHORT).show();
                }
                    try {
                        OutputStreamWriter file = new OutputStreamWriter(openFileOutput(titulo +".txt", Context.MODE_PRIVATE));
                        file.write(contenido);

                        Toast.makeText(Escribir.this, "Nota guardada", Toast.LENGTH_SHORT).show();
                        file.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        });

    }
}