package com.rodrigosoares;

import java.io.Serializable;
import java.util.ArrayList;

public class Pacote implements Serializable {
    private ArrayList<String> nomeCidades;
    private long tempoDeBusca;
    private boolean somenteIda;

    public Pacote() throws Exception{
        nomeCidades = new ArrayList<>();
        tempoDeBusca = 180;
    }

    public void addTempo(long tempoDeBusca){
        this.tempoDeBusca = tempoDeBusca;
    }

    public void addCidade(String nome) throws Exception{
        if(nome == null || nome =="")
            throw new Exception("Cidade invalida!");

        nomeCidades.add(nome);
    }

    public boolean isSomenteIda() {
        return somenteIda;
    }

    public void setSomenteIda(boolean somenteIda) {
        this.somenteIda = somenteIda;
    }

    public ArrayList<String> getNomeCidades(){
        return this.nomeCidades;
    }

    public long getTempoDeBusca() {
        return this.tempoDeBusca;
    }
}
