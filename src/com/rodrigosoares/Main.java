package com.rodrigosoares;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            Mapa mapa = new Mapa();
            ArrayList<Cidade> cidades = mapa.getCidades();
            ArrayList<Rota> todasRotas = new ArrayList<>();

            for(int i=0; i<cidades.size(); i++) {
                System.out.println(cidades.get(i).getNome());
            }

            ArrayList<Rota> menorRota = mapa.menorRota("Valinhos");
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
