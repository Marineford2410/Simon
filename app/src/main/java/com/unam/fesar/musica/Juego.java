package com.unam.fesar.musica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Juego extends AppCompatActivity {

    TextView txtNombre, txtScore;
    ImageView verde, rojo, amarillo, azul;
    String nombre;
    Simon mSimon = new Simon();
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtScore = (TextView)findViewById(R.id.txtScore);
        verde = (ImageView)findViewById(R.id.imgVerde);
        rojo = (ImageView)findViewById(R.id.imgRojo);
        amarillo = (ImageView)findViewById(R.id.imgAmarillo);
        azul = (ImageView)findViewById(R.id.imgAzul);

        Bundle costal = getIntent().getExtras();
        nombre = costal.getString("nombre");
        txtNombre.setText(nombre);
        txtScore.setText(txtScore.getText().toString() + " " + score);

        
    }

    public void algo(){
        verde.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    verde.setImageResource(mSimon.getColorClaro(0));
                    /*MediaPlayer spotify;
                    spotify = MediaPlayer.create(getBaseContext(), R.raw.snk);
                    spotify.start();*/
                }

                if (event.getAction() == MotionEvent.ACTION_UP){
                    verde.setImageResource(mSimon.getColorOscuro(0));
                    score++;
                    txtScore.setText("Score: " + score);
                }
                return true;
            }
        });

        rojo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    rojo.setImageResource(mSimon.getColorClaro(1));
                }

                if (event.getAction() == MotionEvent.ACTION_UP){
                    rojo.setImageResource(mSimon.getColorOscuro(1));
                    score++;
                    txtScore.setText("Score: " + score);
                }

                return true;
            }

        });

        amarillo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    amarillo.setImageResource(mSimon.getColorClaro(2));
                }

                if (event.getAction() == MotionEvent.ACTION_UP){
                    amarillo.setImageResource(mSimon.getColorOscuro(2));
                    score++;
                    txtScore.setText("Score: " + score);
                }

                return true;
            }

        });

        azul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    azul.setImageResource(mSimon.getColorClaro(3));
                }

                if (event.getAction() == MotionEvent.ACTION_UP){
                    azul.setImageResource(mSimon.getColorOscuro(3));
                    score++;
                    txtScore.setText("Score: " + score);
                }

                return true;
            }

        });
    }

}
