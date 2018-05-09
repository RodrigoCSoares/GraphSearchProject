package com.rodrigosoares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Mapa {
    private ArrayList<Cidade> cidades;
    private Stack< ArrayList<Rota> > stack = new Stack<>();


    public Mapa(ArrayList<Cidade> cidades) throws Exception{
        if(cidades == null)
            throw new Exception ("Cidades invalidas!");

        this.cidades = new ArrayList<>(cidades);

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

            //Verifica se a rota atual passa por todas as cidades (nós) desejados e a última cidade é a origem
            //printaRotas(rotaAtual);

            if(contemTodasAsCidades(rotaAtual) && rotaAtual.get(rotaAtual.size()-1).getDestino()==origem){
                System.out.print("ACHOU UMA!" + menorDistancia);
                for (int i = 0; i < rotaAtual.size(); i++) {
                    distanciaAtual += rotaAtual.get(i).distancia;
                    if(distanciaAtual>menorDistancia)
                        break;
                }
                if (distanciaAtual < menorDistancia) {
                    menorDistancia = distanciaAtual;
                    menorRota = rotaAtual;
                }
            }

            else{
                ArrayList<Rota> proximasRotas =  rotaAtual.get(rotaAtual.size()-1).getDestino().getRotas();

                //Adiciona todas as rotas da ultima cidade (nó) visitada na pilha
                for (int i=0 ; i<proximasRotas.size(); i++) {
                    ArrayList<Rota> novaRota = new ArrayList<>(rotaAtual);

                    //Verifica se a rota a ser adicionada na pilha não contem cidades repetidas
                    if(!contemCidadesRepetidas(rotaAtual, origem)) {
                        proximasRotas.get(i).getDestino();
                        novaRota.add(proximasRotas.get(i));
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
            Cidade cidadeAtual = rota.get(i).getDestino();
            //Verifica se a cidade é isolada
            if(cidadeAtual.getRotas().size() == 1){
                cidadeAtual.getRotas().get(0).getDestino().setVizinhaDeIsolada(true);
            }
            else
                cidadeAtual.getRotas().get(0).getDestino().setVizinhaDeIsolada(false);
            //Verifica se a cidade está repetida
            if ((!cidadeAtual.isVizinhaDeIsolada()) && cidadesContidas.contains(cidadeAtual))
                return true;
            else
                //Adiciona a cidade nos Array de cidades da rota, somente se não for vizinha de alguma cidade isolada
                if(!cidadeAtual.isVizinhaDeIsolada())
                    cidadesContidas.add(cidadeAtual);
        }
        return false;
    }

    /*
    private boolean proximaCidadeRepetida (ArrayList<Rota> rota){
        if(rota.size()>2) {
            if (rota.get(rota.size()-1).getDestino().isVisitada()) {
                //Verifica se a cidade anterior esta isolada
                if (rota.get(rota.size() - 2).getDestino().getRotas().size() == 1)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    */

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

    private void printaRotas(ArrayList<Rota> rotas){
        int i;
        System.out.print("[");
        for (i=0; i<rotas.size()-1; i++)
            System.out.print(rotas.get(i).getDestino().getNome()+", ");

        System.out.print(rotas.get(i).getDestino().getNome()+"]\n");
    }
}
