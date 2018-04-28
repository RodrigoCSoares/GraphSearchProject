package com.rodrigosoares;

import java.util.ArrayList;

public class Rota {
    private Cidade cidadeUm;
    private Cidade cidadeDois;
    private int distacia;

    public Rota(Cidade cidadeUm, Cidade cidadeDois, int distacia) throws Exception{
        if(cidadeUm == null || cidadeDois==null || distacia<=0)
            throw new Exception("Rota inválida!");

        this.cidadeUm = cidadeUm;
        this.cidadeDois = cidadeDois;
        this.distacia = distacia;
    }

    public Cidade getCidadeUm(){
        return this.cidadeUm;
    }

    public Cidade getCidadeDois(){
        return this.cidadeDois;
    }

    public int getDistacia(){
        return this.distacia;
    }


    public String toString() {
        String ret = "["+this.cidadeUm+", "+this.cidadeDois+", "+this.distacia+"]";
        return ret;
    }

}
