package com.example.adaptadores;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pokemon[] datos = new Pokemon[]{
                new Pokemon("Planta", "Bulbasur", 1),
                new Pokemon("Fuego", "Charmander", 2),
                new Pokemon("Agua", "Squirtle", 3),
                new Pokemon("Planta", "Oddish", 4),
                new Pokemon("Fuego", "Vulpix", 5),
                new Pokemon("Agua", "Psyduck", 6),
                new Pokemon("Planta", "Bellsprout", 7),
                new Pokemon("Fuego", "Growlithe", 8),
                new Pokemon("Agua", "Poliwag", 9)
        };

        ListView lista = findViewById(R.id.lista);

        Adaptador adaptador = new Adaptador(this, datos);

        lista.setAdapter(adaptador);
    }
}