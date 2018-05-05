package com.rodrigosoares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Mapa {
    private ArrayList<Cidade> cidades = new ArrayList<>();
    private Stack< ArrayList<Rota> > stack = new Stack<>();


    public Mapa() throws Exception{
        Cidade Campinas = new Cidade ("Campinas");
        Cidade SaoPaulo = new Cidade ("Sao Paulo");
        Cidade Valinhos = new Cidade ("Valinhos");
        Cidade Paulinia = new Cidade("Paulinia");
        Cidade Jundiai = new Cidade("Jundiai");
        cidades.add(Campinas);
        cidades.add(SaoPaulo);
        cidades.add(Valinhos);
        cidades.add(Paulinia);
        cidades.add(Jundiai);


        Campinas.addRota(SaoPaulo, 10);
        Campinas.addRota(Valinhos, 5);
        Campinas.addRota(Paulinia, 7);

        Valinhos.addRota(Campinas, 10);
        Valinhos.addRota(Paulinia, 3);

        Paulinia.addRota(Campinas, 7);
        Paulinia.addRota(Valinhos, 3);
        Paulinia.addRota(SaoPaulo, 20);
        Paulinia.addRota(Jundiai, 5);

        SaoPaulo.addRota(Campinas, 10);
        SaoPaulo.addRota(Paulinia, 20);
        SaoPaulo.addRota(Jundiai, 10);

        Jundiai.addRota(Paulinia, 5);
        Jundiai.addRota(SaoPaulo, 10);
    }

    public ArrayList<Cidade> getCidades(){
        return this.cidades;
    }

    public Cidade getCidade(String nome)throws Exception{
        for (int i=0; i<cidades.size(); i++){
            if(cidades.get(i).getNome() == nome)
                return cidades.get(i);
        }
        throw new Exception("Cidade inexistente!");
    }


    public ArrayList<Rota> menorRota(String nomeOrigem) throws Exception{
        int menorDistancia=-1;
        int distanciaAtual;
        ArrayList<Rota> menorRota = null;
        Cidade origem = getCidade(nomeOrigem);
        ArrayList<Rota> rotaAtual;
        ArrayList<Rota> rotasDaOrigem = origem.getRotas();

        for (int i=0 ; i<rotasDaOrigem.size(); i++){
            ArrayList<Rota> novaRota = new ArrayList<>();
            novaRota.add(rotasDaOrigem.get(i));
            stack.add(novaRota);
        }

        while (!stack.empty()){
            rotaAtual = stack.pop();
            distanciaAtual=0;
            //if(rotaAtual.get(rotaAtual.size()-1).destino.getNome() == nomeOrigem) {
            System.out.println(rotaAtual.get(rotaAtual.size()-1).destino.getNome());
            if(contemTodasAsCidades(rotaAtual)){
                for (int i = 0; i < rotaAtual.size(); i++) {
                    distanciaAtual += rotaAtual.get(i).distancia;
                }
                if (distanciaAtual < menorDistancia) {
                    menorDistancia = distanciaAtual;
                    menorRota = rotaAtual;
                }
            }

            else{
                //for (int i=0 ; i<rotaAtual.size(); i++){
                //    ArrayList<Rota> novaRota = new ArrayList<>(rotaAtual);
                //    novaRota.add(rotaAtual.get(i));
                //    stack.add();
            }
        }
        return menorRota;
    }

    private boolean contemTodasAsCidades(ArrayList<Rota> rotas){
        ArrayList<Cidade> cidades = new ArrayList<>();
        for (int i=0; i<rotas.size(); i++){
            cidades.add(rotas.get(i).destino);
        }

        if(cidades==this.cidades)
            return true;
        return false;
    }

}
