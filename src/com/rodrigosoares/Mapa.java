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

        Valinhos.addRota(Campinas, 5);
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
        int menorDistancia=999999999;
        int distanciaAtual;
        ArrayList<Rota> menorRota = null;
        Cidade origem = getCidade(nomeOrigem);
        ArrayList<Rota> rotaAtual;
        ArrayList<Rota> rotasDaOrigem = origem.getRotas();

        //Adiciona todas as rotas da origem na pilha
        for (int i=0 ; i<rotasDaOrigem.size(); i++){
            ArrayList<Rota> novaRota = new ArrayList<>();
            novaRota.add(rotasDaOrigem.get(i));
            System.out.println("Rotas da origem:"+rotasDaOrigem.get(i).getDestino());
            stack.add(novaRota);
        }

        //Verifica se todas as rotas da pilha já foram testadas
        while (!stack.empty()){
            rotaAtual = stack.pop();
            distanciaAtual=0;
            //System.out.println(rotaAtual.get(rotaAtual.size()-1).destino.getNome());
            //Verifica se a rota atual passa por todas as cidades (nós) desejados
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
                //Adiciona todas as rotas da ultima cidade (nó) visitada na pilha
                for (int i=0 ; i<rotaAtual.get(rotaAtual.size()-1).getDestino().getRotas().size(); i++) {
                    ArrayList<Rota> novaRota = new ArrayList<>(rotaAtual);
                    //Verifica se a rota a ser adicionada na pilha não contem cidades repetidas
                    if(!contemCidadesRepetidas(rotaAtual, origem)) {
                        novaRota.add(rotaAtual.get(rotaAtual.size() - 1).getDestino().getRotas().get(i));
                        System.out.println("Destino: " + novaRota.get(novaRota.size() - 1).getDestino() + " | Size: " + novaRota.size());
                        stack.add(novaRota);
                    }
                }
            }
        }
        return menorRota;
    }

    //Verifica se a rota possue cidades (nós) repetidas
    private boolean contemCidadesRepetidas(ArrayList<Rota> rota, Cidade origem){
        ArrayList<Cidade> cidadesContidas = new ArrayList<>();
        cidadesContidas.add(origem);

        for(int i=0; i<rota.size(); i++){
            if(cidadesContidas.contains(rota.get(i).getDestino()))
               return true;
            else
                cidadesContidas.add(rota.get(i).getDestino());
        }
        return false;
    }

    //Verifica se a rota passa por todas as cidades (nós) do mapa
    public boolean contemTodasAsCidades(ArrayList<Rota> rotas){
        ArrayList<Cidade> cidadesCopia = new ArrayList<>(this.cidades);
        ArrayList<Cidade> cidadesNaRota = new ArrayList<>();
        for (int i=0; i<rotas.size(); i++){
            cidadesNaRota.add(rotas.get(i).destino);
        }

        cidadesCopia.removeAll(cidadesNaRota);

        if(cidadesCopia.isEmpty())
            return true;
        return false;
    }

}
