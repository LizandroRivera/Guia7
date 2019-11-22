package com.example.labguia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnJugar, btnVerPuntaje, btnDatos, btnVerRespuesta;
    public static int Numero;
    public static int numeroaleatorio=0;
    public static int puntos=0;
    public static  SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJugar = findViewById(R.id.btnJugar);
        btnVerPuntaje = findViewById(R.id.btnVerPuntaje);
        btnVerRespuesta = findViewById(R.id.btnVerRespuesta);
        btnDatos = findViewById(R.id.btnDatos);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jugar();
            }
        });
        btnVerPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerPuntaje();
            }
        });
        btnVerRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerRespuesta();
            }
        });
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerDatos();
            }
        });

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);


    }

    private void VerDatos() {
        Intent in = new Intent(this, Datos.class);
        startActivity(in);
    }

    private void VerRespuesta() {
        if(numeroaleatorio==0){
            Toast.makeText(this, "Tiene que jugar primero", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent in = new Intent(this, Respuesta.class);
            startActivity(in);
        }

    }

    private void VerPuntaje() {
            puntos = prefs.getInt("puntos1",10);
            Intent in = new Intent(this, Puntaje.class);
            startActivity(in);
    }

    private void Jugar() {
        puntos = prefs.getInt("puntos1",10);
        Intent in = new Intent(this, Juego.class);
        startActivity(in);
    }
}
