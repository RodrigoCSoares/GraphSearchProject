package com.rodrigosoares;

import java.util.ArrayList;

public class Main {

    private static void inicializaCidades(ArrayList<Cidade> cidades) throws Exception{
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

    public static void main(String[] args) {
        try {
            Mapa mapa;
            ArrayList<Cidade> cidades = new ArrayList<>();

            inicializaCidades(cidades);

            mapa = new Mapa(cidades);

            ArrayList<Rota> menorRota = mapa.menorRota("Sao Paulo");
            System.out.println("----------------MENOR ROTA----------------");
            for (int i=0; i<menorRota.size(); i++){
                System.out.print(menorRota.get(i).getDestino().getNome()+", ");
            }

        }
        catch (Exception e ){
            System.err.println(e.getMessage());
        }
    }
}
