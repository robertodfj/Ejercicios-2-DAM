package com.example.dialogos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.boton1);

        AlertDialog.Builder constructor = new AlertDialog.Builder(this);

        constructor.setTitle("Esto es un dialogo");
        constructor.setMessage("Hola, este es mi primer dialog");
        constructor.setIcon(R.drawable.ic_launcher_background);
        constructor.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast tostada = Toast.makeText(getApplicationContext(), "Funciona el si", Toast.LENGTH_SHORT);
                tostada.show();
            }
        });

        AlertDialog dialogo = constructor.create();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.show();
            }
        });
    }
}