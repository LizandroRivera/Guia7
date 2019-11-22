package com.example.labguia7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.labguia7.MainActivity.numeroaleatorio;

public class Respuesta extends AppCompatActivity {

    TextView txtRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);

        txtRespuesta = findViewById(R.id.txtRespuesta);

        if(numeroaleatorio != 0){
            txtRespuesta.setText(Integer.toString(numeroaleatorio));
        }
    }
}
