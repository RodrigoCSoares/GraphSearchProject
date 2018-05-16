package com.rodrigosoares.Servidor;


import java.io.Serializable;

public class Rota implements Serializable {
    Cidade destino;
    int distancia;
    boolean visitada;

    public Rota (Cidade destino, int distancia) throws Exception{
        if(destino == null || distancia<=0)
            throw new Exception("Rota invalida!");

        this.destino = destino;
        this.distancia = distancia;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setVisitada(boolean b){
        this.visitada = b;
    }

    public boolean isVisitada() {
        return this.visitada;
    }

}
