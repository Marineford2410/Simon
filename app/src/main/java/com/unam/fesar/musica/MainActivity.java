package com.unam.fesar.musica;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre;
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText)findViewById(R.id.edtNombre);
        btnIniciar = (Button)findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtNombre.getText().toString().equals("")){
                    Intent i = new Intent(getBaseContext(), Juego.class);
                    i.putExtra("nombre", edtNombre.getText().toString());
                    startActivity(i);
                }
                else{
                    Toast.makeText(getBaseContext(), "Ingresa un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });


/*
        MediaPlayer spotify;
        spotify = MediaPlayer.create(getBaseContext(), R.raw.snk);
        spotify.start();
        */

/*
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        }.start();
*/
    }
}
