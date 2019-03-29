package com.unam.fesar.musica;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Juego extends AppCompatActivity {

    // Elementos XML
    private TextView    txtNombre, txtScore;
    private ImageView   verde, rojo, amarillo, azul;
    private Button      btnIniciar;

    // Funcionamiento
    private MediaPlayer sonido;
    private String      nombre;
    private Simon       mSimon;
    private int         score;
    private int         turno;                          // 0 -> Maquina, 1 -> Jugador;

    public Juego(){
        mSimon = new Simon();
        score = 0;
        turno = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        // Relacionamos cada variable con su elemento XML
        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtScore = (TextView)findViewById(R.id.txtScore);
        btnIniciar = (Button)findViewById(R.id.btnIniciar);
        verde = (ImageView)findViewById(R.id.imgVerde);
        rojo = (ImageView)findViewById(R.id.imgRojo);
        amarillo = (ImageView)findViewById(R.id.imgAmarillo);
        azul = (ImageView)findViewById(R.id.imgAzul);

        // Obtenemos el nombre enviado desde MainActivity
        Bundle costal = getIntent().getExtras();
        nombre = costal.getString("nombre");
        txtNombre.setText(nombre);                                      // Lo establecemos en el TextView

        txtScore.setText(txtScore.getText().toString() + " " + score);  // Establecemos el puntaje = 0

        mSimon.agregarSonido();
        mSimon.agregarSonido();
        mSimon.agregarSonido();
        mSimon.agregarSonido();
        mSimon.agregarSonido();
        mSimon.agregarSonido();



        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnIniciar.setVisibility(View.INVISIBLE);

                new CountDownTimer(2000, 1000) {
                    int tamanio = getSimon().getMaquina().size();   // Tamaño del la secuencia
                    int i = 0;                                      // Indice, recorerá cada valor del arrayList Maquina
                    int valor = getSimon().getMaquina().get(i);     // Controlara el color y el sonido que corresponda al indice

                    @Override
                    public void onTick(long millisUntilFinished) {
                        // Log.i("Tiempo", "Tiempo: " + millisUntilFinished );
                        sonido = MediaPlayer.create(getBaseContext(), getSimon().getSonido(valor)); // Se le asigna el sonido correspondiente
                        colores(valor,0);                                   // Prendera el boton corresponsiente
                        if (!sonido.isPlaying() || sonido.equals(null)){                 // Si sonido no esta sonando
                            sonido.start(); // Inicia el sonido
                        }
                    }

                    @Override
                    public void onFinish() {
                        Log.i("Tiempo", "Tiempo Finalizado" );
                        Log.i("comparacion", "Indice: " + i + " Valor: " + valor + " Tamaño: " + tamanio);
                        // Log.i("comparacion", " "+i);
                        colores(valor,1);               // Apaga el boton
                        if(i < tamanio) {                            // Si todavia no se ha recorrido array
                            //Log.i("comparacion", "Finalizo el sonido");
                            //Log.i("comparacion", ""+i+" < "+tamanio);
                            i++;                                     // Continua con el siguiente
                            // Log.i("comparacion", "Indice: "+i);
                            if (!(i == tamanio)){
                                valor = getSimon().getMaquina().get(i);  // Establece el nuevo valor
                                this.start();                            // Vuelve a iniciar
                            }
                            else {
                                btnIniciar.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }.start();

            }
        });

    }

    public Simon getSimon() {
        return mSimon;
    }

    public void colores(int id, int claroOrOscuro){

        if (claroOrOscuro == 0){ //Si es claro
            switch (id){
                case 0:
                    verde.setImageResource(mSimon.getColorClaro(id));
                    break;
                case 1:
                    rojo.setImageResource(mSimon.getColorClaro(id));
                    break;
                case 2:
                    amarillo.setImageResource(mSimon.getColorClaro(id));
                    break;
                case 3:
                    azul.setImageResource(mSimon.getColorClaro(id));
                    break;
                default:
                    break;
            }
        }
        else {
            switch (id){
                case 0:
                    verde.setImageResource(mSimon.getColorOscuro(id));
                    break;
                case 1:
                    rojo.setImageResource(mSimon.getColorOscuro(id));
                    break;
                case 2:
                    amarillo.setImageResource(mSimon.getColorOscuro(id));
                    break;
                case 3:
                    azul.setImageResource(mSimon.getColorOscuro(id));
                    break;
                default:
                    break;
            }
        }


        /*
        verde.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    verde.setImageResource(mSimon.getColorClaro(0));
                    MediaPlayer spotify;
                    spotify = MediaPlayer.create(getBaseContext(), R.raw.snk);
                    spotify.start();
                }

                if (event.getAction() == MotionEvent.ACTION_UP){
                    verde.setImageResource(mSimon.getColorOscuro(0));
                    score++;
                    txtScore.setText("Score: " + score);
                }
                return true;
            }
        });
        */
        /*
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
        */ /*
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
        */ /*
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

        });*/
    }

}
