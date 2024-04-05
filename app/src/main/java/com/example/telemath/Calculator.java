package com.example.telemath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }


    public void iraRegistro(View view) {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

    public void convertirTextoANumero(View view) {
        Button botonPresionado = (Button) view;
        TextView textViewNumero = findViewById(R.id.textView3);

        // Obtener el texto del botón presionado
        String textoBoton = botonPresionado.getText().toString();

        // Mostrar el texto en el TextView
        textViewNumero.setText("Número: " + textoBoton);
    }
}
