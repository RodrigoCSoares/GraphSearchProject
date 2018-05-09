package com.rodrigosoares;

import java.util.ArrayList;

public class ArrayRotas {
    private ArrayList<Rota> rota;
    private int distancia;

    public ArrayRotas(){
        this.rota = new ArrayList<>();
        this.distancia = 0;
    }

    public ArrayRotas (ArrayRotas modelo) throws Exception{
        if(modelo == null)
            throw new Exception("Modelo invalido!");

        this.rota = new ArrayList<>(modelo.rota);
        this.distancia = modelo.distancia;
    }

    public ArrayRotas (ArrayList<Rota> rota, int distancia) throws Exception{
        if(rota == null || distancia<1)
            throw new Exception("Modelo invalido!");
    }

    public ArrayRotas (ArrayList<Rota> rota) throws Exception{
        if(rota == null)
            throw new Exception("Modelo invalido");

        this.rota = new ArrayList<>(rota);
        this.distancia = 0;
    }

    public void addDistancia (int distancia) throws Exception{
        if (distancia<=0) throw new Exception("Distancia invalida!");

        this.distancia += distancia;
    }

    public void addRota (Rota rota) throws Exception{
        if (rota == null) throw new Exception("Rota invadlida!");

        this.rota.add(rota);
        this.distancia += rota.distancia;
    }
}
