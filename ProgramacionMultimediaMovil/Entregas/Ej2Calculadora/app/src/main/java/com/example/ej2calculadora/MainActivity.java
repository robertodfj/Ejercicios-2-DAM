package com.example.ej2calculadora;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnPunto, btnMas, btnMenos, btnDiv, btnMulti, btnAc, btnBorrar, btnIgual,

            btnModo;

    TextView textView;
    ConstraintLayout mainLayout;

    // Historial de operaciones
    Spinner historialOperaciones;
    ArrayAdapter<String> adapter;
    List<String> historial = new ArrayList<>();

    Double numero1 = (double) 0;
    Double numero2 = (double) 0;
    boolean nuevoNumero = true;
    char operador;

    String operacion = "0";

    Boolean modo = true;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Numeros
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

        // Char
        btnPunto = (Button) findViewById(R.id.btnPunto);
        btnMas = (Button) findViewById(R.id.btnMas);
        btnMenos = (Button) findViewById(R.id.btnMenos);
        btnDiv = (Button) findViewById(R.id.btnDivision);
        btnMulti = (Button) findViewById(R.id.btnMultiplicar);
        btnIgual = (Button) findViewById(R.id.btnIgual);

        // Acciones
        btnAc = (Button) findViewById(R.id.btnAC);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnModo = (Button) findViewById(R.id.btnModo);
        textView = (TextView) findViewById(R.id.textView);
        mainLayout = findViewById(R.id.main);
        // Historial
        historialOperaciones = findViewById(R.id.historialOperaciones);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, historial);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        historialOperaciones.setAdapter(adapter);


        // Listener de numeros y operadores:
        btn0.setOnClickListener(v -> agregarNumero("0"));
        btn1.setOnClickListener(v -> agregarNumero("1"));
        btn2.setOnClickListener(v -> agregarNumero("2"));
        btn3.setOnClickListener(v -> agregarNumero("3"));
        btn4.setOnClickListener(v -> agregarNumero("4"));
        btn5.setOnClickListener(v -> agregarNumero("5"));
        btn6.setOnClickListener(v -> agregarNumero("6"));
        btn7.setOnClickListener(v -> agregarNumero("7"));
        btn8.setOnClickListener(v -> agregarNumero("8"));
        btn9.setOnClickListener(v -> agregarNumero("9"));
        btnMas.setOnClickListener(v -> agregarOperador('+'));
        btnMenos.setOnClickListener(v -> agregarOperador('-'));
        btnMulti.setOnClickListener(v -> agregarOperador('*'));
        btnDiv.setOnClickListener(v -> agregarOperador('/'));
        btnPunto.setOnClickListener(v -> agregarPunto());
        btnModo.setOnClickListener(v -> cambioModo());

        btnIgual.setOnClickListener(v -> calcular());

        btnBorrar.setOnClickListener(v -> limpiar());
        btnAc.setOnClickListener(v -> limpiar());


    }

    public void agregarNumero(String numeroPulsado){
        if (nuevoNumero) {
            nuevoNumero = false;
            operacion = numeroPulsado.toString();
            textView.setText(numeroPulsado);
        } else {
            operacion = operacion + numeroPulsado;
            textView.setText(operacion);
        }
    }

    public void agregarPunto(){
        if (nuevoNumero){
            textView.setText("0.");
            operacion = "0.";
        } else {
            String operacionExistente = textView.getText().toString();
            if (!operacionExistente.contains(".")) {
                textView.setText(operacionExistente + ".");
                operacion = operacion + ".";
            }
        }
    }

    public void agregarOperador(Character operadorPulsado){
        numero1 = Double.parseDouble(textView.getText().toString());
        operacion = operacion + operadorPulsado;
        textView.setText(operacion);
        operador = operadorPulsado;
        nuevoNumero = true;
    }

    public void calcular(){
        numero2 = Double.parseDouble(textView.getText().toString());
        double resultado = 0;
        switch (operador){
            case '+': resultado = numero1 + numero2; break;
            case '-': resultado = numero1 - numero2; break;
            case '*': resultado = numero1 * numero2; break;
            case '/': if (numero2 != 0){
                    resultado = numero1 / numero2;
                } else {
                    textView.setText("Sin definir");
                    nuevoNumero = true;
                    return;
                } break;
        }

        textView.setText(String.valueOf(resultado));
        nuevoNumero = true;
        String operacionCompleta = numero1 + "" +operador+""+numero2+ "= " + resultado;

        agregarHistorial(operacionCompleta);
    }

    public void limpiar(){
        operacion = "";
        nuevoNumero = true;
        textView.setText("0");
    }

    public void cambioModo(){
        if (modo){
            btnModo.setText("🌜");
            modo = false;
            mainLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
            textView.setTextColor(getResources().getColor(android.R.color.black));

        } else {
            modo = true;
            btnModo.setText("☀️");
            mainLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
            textView.setTextColor(getResources().getColor(android.R.color.white));
        }
    }

    public void agregarHistorial(String ope){
        if (historial.size() == 3){
            historial.remove(0);
        }
        historial.add(ope);
        adapter.notifyDataSetChanged();
    }

}