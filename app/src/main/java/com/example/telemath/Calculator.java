package com.example.telemath;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    int digitos = 0;
    String operation = "";
    int sumando = 1;
    double factor = 0;

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
        Log.d("msg",textovista);

        String textovista2  = textViewNumero2.getText().toString();
        Log.d("msg",textovista2);
        if(sumando == 1){
            try {
                // Convertir el texto a un entero usando el método parseInt de la clase Integer
                int entero = Integer.parseInt(textoBoton);
                int numeroprevio  = Integer.parseInt(textovista);
                int numero_ahora = numeroprevio*(int) Math.pow(10, digitos)+ entero;
                String number = String.valueOf(numero_ahora);
                factor = Double.parseDouble(number);
                String numero_texto = String.valueOf(numero_ahora);
                Log.d("msg",numero_texto);
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
                int numero_ahora1 = numeroprevio1* (int) Math.pow(10, digitos)+ entero;
                String numero_texto1 = String.valueOf(numero_ahora1);
                Log.d("msg",numero_texto1);
                // Mostrar el texto en el TextView
                textViewNumero2.setText(numero_texto1);

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
            Log.d("msg",operation);
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
            Log.d("msg","total entra factor:");
            Log.d("msg",String.valueOf(factor));

            if(operation.equals("+")){
                result  = factor+numero2suma;
            } else if (operation.equals("-")) {
                result = factor-numero2suma;
            } else if (operation.equals("/")) {
                result = factor/numero2suma;
            } else if (operation.equals("*")) {
                result = factor*numero2suma;
            }
            factor = result;
            Log.d("msg","Factor luego:");
            String factoresultante = String.valueOf(factor);
            Log.d("msg",factoresultante);
            String resulttexto = String.valueOf(result);
            Log.d("msg",resulttexto);
            sumando1.setText("0");
            sumando2.setText(resulttexto);
            operation = "";

        } catch (NumberFormatException e) {
        }
        sumando = 2;
    }


    public void clear(View view) {
        digitos = 0;
        operation = "";
        sumando = 1;
        factor = 0;
        Button botonOperador = (Button) view;
        TextView textViewNumero = findViewById(R.id.textView3);
        TextView textViewNumero2 = findViewById(R.id.textView8);

        textViewNumero2.setText("0");
        textViewNumero.setText("0");
    }
}
