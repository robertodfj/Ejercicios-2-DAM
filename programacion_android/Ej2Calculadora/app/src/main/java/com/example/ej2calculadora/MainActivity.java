package com.example.ej2calculadora;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        // Tenemos que guardar los numeros como num1 y concatenarlos y pasarlos a double o int hasta pulsar el signo de op
        // Hacemos lo mismo con num2 hasta pulsar =, realizamos la operacion

        // Añadir numero1 char numero 2
        // Añadir boolean si es nuevo numero o no
        // Añadir onclick listeners

        List<String> operacion = new ArrayList<>();
        // Se usara para imprimir la operacion completa



    }

    public void agregarNumero(String numero){

    }

}