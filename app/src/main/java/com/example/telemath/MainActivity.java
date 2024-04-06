package com.example.telemath;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button botonA = findViewById(R.id.button22);
        registerForContextMenu(botonA);

    }

    public void irAIndicaciones(View view) {
        Intent intent = new Intent(this, Indicaciones.class);
        startActivity(intent);
    }


    public void irACalcular(View view) {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.red){
            cambiarColorBoton(Color.RED);
            return true;
        }else if(id == R.id.green){
            cambiarColorBoton(Color.GREEN);
            return true;
        }else if (id == R.id.blue){
            cambiarColorBoton(Color.BLUE);
            return true;
        }else {
            return super.onContextItemSelected(item);
        }
    }

    private void cambiarColorBoton(int color) {
        Button botonA = findViewById(R.id.button22);
        botonA.setTextColor(color);
    }



}