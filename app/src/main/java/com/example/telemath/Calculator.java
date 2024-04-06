package com.example.telemath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    int digitos = 0;
    String operation = "";
    int sumando = 1;

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
        TextView textViewNumero2 = findViewById(R.id.textView8);

        // Obtener el texto del botón presionado
        String textoBoton = botonPresionado.getText().toString();
        String textovista = textViewNumero.getText().toString();
        String textovista2  = textViewNumero2.getText().toString();
        if(sumando == 1){
            try {
                // Convertir el texto a un entero usando el método parseInt de la clase Integer
                int entero = Integer.parseInt(textoBoton);
                int numeroprevio  = Integer.parseInt(textovista);
                int numero_ahora = numeroprevio*10^digitos + entero;
                String numero_texto = "" +numero_ahora;
                // Mostrar el texto en el TextView
                textViewNumero.setText(numero_texto);

                digitos = digitos +1;
            } catch (NumberFormatException e) {
            }
        }else if(sumando ==2){

            try {
                // Convertir el texto a un entero usando el método parseInt de la clase Integer
                int entero = Integer.parseInt(textoBoton);
                int numeroprevio1  = Integer.parseInt(textovista2);
                int numero_ahora1 = numeroprevio1*10^digitos + entero;
                String numero_texto1 = "" +numero_ahora1;
                // Mostrar el texto en el TextView
                textViewNumero.setText(numero_texto1);

                digitos = digitos +1;
            } catch (NumberFormatException e) {
            }
        }


    }

    public void seleccionarOperacion(View view) {
        digitos = 0;
        Button botonOperador = (Button) view;
        TextView textViewNumero = findViewById(R.id.textView3);
        TextView textViewNumero2 = findViewById(R.id.textView8);

        // Obtener el texto del botón presionado
        String textoBoton = botonOperador.getText().toString();
        String textovista = textViewNumero.getText().toString();


        try {
            // Convertir el texto a un entero usando el método parseInt de la clase Integer
            int numeroprevio  = Integer.parseInt(textovista);
            String ope = numeroprevio+textoBoton;
            operation = textoBoton;
            // Mostrar el texto en el TextView
            textViewNumero.setText(ope);

        } catch (NumberFormatException e) {
        }
        sumando = 2;
    }

    public void total(View view) {
        digitos = 0;
        Button botonOperador = (Button) view;
        TextView sumando1 = findViewById(R.id.textView3);
        TextView sumando2 = findViewById(R.id.textView8);
        String sumando1string = sumando1.getText().toString();
        String sumando2string = sumando2.getText().toString();


        try {
            // Convertir el texto a un entero usando el método parseInt de la clase Integer
            double numero1suma  = Integer.parseInt(sumando1string);
            double numero2suma = Integer.parseInt(sumando2string);
            double result = 0;

            if(operation.equals("+")){
                result  = numero1suma+numero2suma;

            } else if (operation.equals("-")) {
                result = numero1suma-numero2suma;
            } else if (operation.equals("/")) {
                result = numero1suma/numero2suma;
            } else if (operation.equals("*")) {
                result = numero1suma*numero2suma;
            }
            String operacionpasada =  sumando1string+operation+sumando2string;
            String resulttexto = ""+result;
            sumando1.setText(operacionpasada);
            sumando2.setText(resulttexto);

        } catch (NumberFormatException e) {
        }
        sumando = 2;
    }


    public void clear(View view) {
        digitos = 0;
        Button botonOperador = (Button) view;
        TextView textViewNumero = findViewById(R.id.textView3);

        // Obtener el texto del botón presionado
        String textoBoton = botonOperador.getText().toString();
        String textovista = textViewNumero.getText().toString();


        try {
            // Convertir el texto a un entero usando el método parseInt de la clase Integer
            int numeroprevio  = Integer.parseInt(textovista);
            String ope = numeroprevio+textoBoton;
            operation = textoBoton;
            // Mostrar el texto en el TextView
            textViewNumero.setText(ope);

        } catch (NumberFormatException e) {
        }
    }
}
