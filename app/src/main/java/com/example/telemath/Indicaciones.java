package com.example.telemath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Indicaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indicaciones);

        /*Intent intent1 = getIntent();
        String texto = intent1.getStringExtra("texto");
        Persona persona = (Persona) intent1.getSerializableExtra("alumna");

        TextView textView = findViewById(R.id.textView2);
        textView.setText("texto: " + texto + " | persona: " + persona.getNombre());

        Button button = findViewById(R.id.buttonRegresar);
        button.setOnClickListener(view -> {
            //Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            //startActivity(intent);
            //para regresar al MainActivity ya creado
            finish();
        });*/
    }

    public void irACalcular(View view) {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }
}
