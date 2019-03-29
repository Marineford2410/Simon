package com.unam.fesar.musica;

import java.util.ArrayList;
import java.util.Random;

public class Simon {

    private final int[] claro;
    private final int[] oscuro;
    private final int[] sonido;
    private ArrayList<Integer> maquina;
    private ArrayList<Integer> jugador;

    public Simon(){
        claro = new int[]{R.color.verdeClaro, R.color.rojoClaro, R.color.amarilloClaro, R.color.azulClaro};
        oscuro = new int[]{R.color.verdeOscuro, R.color.rojoOscuro, R.color.amarilloOscuro, R.color.azulOscuro};
        sonido = new int[]{R.raw.perro, R.raw.gato, R.raw.vaca, R.raw.caballo};
        this.maquina = new ArrayList<Integer>();
        this.jugador = new ArrayList<Integer>();
        agregarSonido();
    }

    public ArrayList<Integer> getMaquina() {
        return maquina;
    }

    public void agregarSonido(){
        Random random = new Random();
        int i =  random.nextInt(4);
        maquina.add(i);
    }

    public int getColorOscuro(int id) {
        int colorOscuro = this.oscuro[id];
        return colorOscuro;
    }

    public int getColorClaro(int id) {
        int colorClaro = this.claro[id];
        return colorClaro;
    }

    public int getSonido(int id) {
        int animal = this.sonido[id];
        return animal;
    }
}
