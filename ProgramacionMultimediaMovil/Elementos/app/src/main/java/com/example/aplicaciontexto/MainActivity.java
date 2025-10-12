package com.example.aplicaciontexto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enviar, personal;
        TextView mostrar;
        EditText editor;

        enviar = (Button) findViewById(R.id.btn_enviar);
        personal = (Button) findViewById(R.id.btn_personalizacion);
        mostrar = (TextView) findViewById(R.id.visorTexto);
        editor = (EditText) findViewById(R.id.entrada);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editor.getText().toString();
                mostrar.setText(texto);

            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Actividad2.class);
                startActivity(i);
            }
        });

    }
}