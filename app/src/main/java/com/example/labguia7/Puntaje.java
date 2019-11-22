package com.example.labguia7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.labguia7.MainActivity.puntos;

public class Puntaje extends AppCompatActivity {

    TextView VerPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

        VerPuntos = findViewById(R.id.VerPuntos);
        VerPuntos.setText(Integer.toString(puntos));
    }
}
