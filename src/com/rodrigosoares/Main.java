package com.rodrigosoares;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            Mapa mapa = new Mapa();
            ArrayList<Cidade> cidades = mapa.getCidades();

            for(int i=0; i<cidades.size(); i++)
                System.out.println(cidades.get(i).getNome());

            System.out.println(mapa.menorRota("Campinas"));
        }
        catch (Exception e ){
            System.err.println(e.getMessage());
        }
    }
}
