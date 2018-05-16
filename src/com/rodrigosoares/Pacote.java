package com.rodrigosoares;

import com.rodrigosoares.Servidor.Cidade;

import java.io.Serializable;
import java.util.ArrayList;

public class Pacote implements Serializable {
    private ArrayList<String> nomeCidades;
    private ArrayList<Cidade> novasCidades;
    private long tempoDeBusca;
    private boolean somenteIda;
    private boolean adicionarCidades;

    public Pacote(){
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

    public ArrayList<Cidade> getNovasCidades() {
        return novasCidades;
    }

    public void setNovasCidades(ArrayList<Cidade> novasCidades) {
        this.novasCidades = novasCidades;
    }

    public boolean getAdicionarCidades() {
        return adicionarCidades;
    }

    public void setAdicionarCidades(boolean adicionarCidades) {
        this.adicionarCidades = adicionarCidades;
    }
}