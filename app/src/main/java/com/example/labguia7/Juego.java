package com.example.labguia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.labguia7.MainActivity.numeroaleatorio;
import static com.example.labguia7.MainActivity.prefs;
import static com.example.labguia7.MainActivity.puntos;

public class Juego extends AppCompatActivity {

    int intentos = 1, puntaje = 0;
    EditText txtjugar;
    Button btnprobar, btnnuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        txtjugar = findViewById(R.id.txtNumeroj);
        btnprobar = findViewById(R.id.btnProbar);
        btnnuevo = findViewById(R.id.btnnuevo);

        if(numeroaleatorio==0){
            numeroaleatorio=(int) (Math.random()*10)+1;
        }

        Toast.makeText(this,"Buena Suerte!",Toast.LENGTH_SHORT).show();

        btnprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProbarJuego();
            }
        });
        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nuevojuego();
            }
        });
    }

    private void Nuevojuego() {
        numeroaleatorio=(int) (Math.random()*10)+1;
    }

    private void ProbarJuego() {
        SharedPreferences.Editor editor = prefs.edit();
        if(txtjugar.getText().toString().isEmpty()){
            Toast.makeText(this,"El campo esta vacio!", Toast.LENGTH_SHORT).show();
        }
        else{
            if(Integer.parseInt(txtjugar.getText().toString()) == numeroaleatorio )
            {

                Toast.makeText(this,"Felicidades, ha encontrado el numero en "+intentos+" intentos", Toast.LENGTH_SHORT).show();

                numeroaleatorio = 0;
                puntaje = 10;
                puntos = puntos + puntaje;
                editor.putInt("puntos1", puntos);
                editor.commit();
                finish();
            }
            else
            {

                intentos++;
                puntaje = 1;
                puntos = puntos - puntaje;
                editor.putInt("puntos1", puntos);
                editor.commit();

                Toast.makeText(this,"Ha fallado! Numero de Intento: "+intentos+" , intente de nuevo!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
