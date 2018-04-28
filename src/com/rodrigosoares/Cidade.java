package com.rodrigosoares;


import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Rota> rotas;

    public Cidade(String nome) throws Exception{
        if(nome=="")
            throw new Exception("Nome inválido!");

        this.nome = nome;
        this.rotas = new ArrayList<>();
    }

    public void addRota(Rota novaRota) throws Exception{
        if(novaRota==null)
            throw new Exception("Rota inválida!");
        rotas.add(novaRota);
    }

    public void removeRota(Rota rota) throws Exception{
        if(rota==null) throw new Exception("Rota inválida");

        rotas.remove(rota);
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Rota> getRotas(){
        return this.rotas;
    }

    public String toString() {
        return this.nome;
    }
}
