package com.rodrigosoares.Servidor;


import java.util.ArrayList;

public class Cidade{
    private String nome;
    private ArrayList<Rota> rotas;
    private boolean vizinhaDeIsolada;
    protected boolean visitada = false;

    public Cidade(String nome) throws Exception{
        if(nome=="")
            throw new Exception("Nome inválido!");

        this.nome = nome;
        this.rotas = new ArrayList<>();
        this.vizinhaDeIsolada = false;
    }

    public Cidade (Cidade modelo) throws Exception{

        if(modelo==null)
            throw new Exception("Cidade invalida!");

        this.nome = modelo.nome;
        this.rotas = new ArrayList<>(modelo.rotas);
        this.vizinhaDeIsolada = modelo.vizinhaDeIsolada;
    }

    public void addRota(Rota novaRota) throws Exception{
        if(novaRota==null)
            throw new Exception("Rota inválida!");
        rotas.add(novaRota);
    }

    public void addRota(Cidade destino, int distancia) throws Exception{
        if(this == destino)
            throw new Exception("Destino invalido!");

        Rota nova = new Rota(destino, distancia);
        rotas.add(nova);
    }

    public void removeRota(Rota rota) throws Exception{
        if(rota==null) throw new Exception("Rota inválida");

        rotas.remove(rota);
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Rota> getRotas(){
        return new ArrayList<>(this.rotas);
    }

    public void setVizinhaDeIsolada(boolean value){
        this.vizinhaDeIsolada = value;
    }

    public boolean isVizinhaDeIsolada(){
        return this.vizinhaDeIsolada;
    }

    public String toString() {
        return this.nome;
    }
}
