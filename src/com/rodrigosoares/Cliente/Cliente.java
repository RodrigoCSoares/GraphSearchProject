package com.rodrigosoares.Cliente;

import com.rodrigosoares.Pacote;

import java.io.*;
import java.net.Socket;

public class Cliente {

    private static Pacote pacoteDoUsuario()throws Exception{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        boolean digitouNumero = false;
        int nCidades = 0;
        String cidade;
        Pacote pacote = new Pacote();

        System.out.println("Qual o tempo (segundos) máximo de busca que você deseja?");
        do {
            try {
                pacote.addTempo(Long.parseLong(teclado.readLine()));
                digitouNumero = true;
            }catch (Exception e){}
        }while (!digitouNumero);


        System.out.println("Você deseja saber o caminho apenas de ida? ('sim' ou 'nao')");
        if(teclado.readLine().toUpperCase().equals("SIM"))
            pacote.setSomenteIda(true);
        else
            pacote.setSomenteIda(false);

        System.out.println("Quantas cidades deseja visitar? (1 - Visita todas as cidades e volta pr a inicial)");
        nCidades = Integer.parseInt(teclado.readLine());

        System.out.println("Digite as cidades que deseja buscar");
        for (int i=0; i<nCidades; i++) {
            cidade = teclado.readLine();
            pacote.addCidade(cidade);
        }

        return pacote;
    }

    public static void main(String args[]){
        try{
            Socket conexao = new Socket("127.0.0.1",9090);
            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());

            //Capta as informacoes que usuario deseja
            Pacote pacote = pacoteDoUsuario();

            //Envia o pacote via socket
            transmissor.writeObject(pacote);
            transmissor.flush();

            //Avisa o usuario que o servidor esta efetuando a busca
            System.out.println("Efetuando a busca...");

            //Printa o resultado

            System.out.println("\nRESULTADO:\n["+ pacote.getNomeCidades().get(0) + receptor.readObject());

            //Fecha a conexao
            receptor.close();
            transmissor.close();
            conexao.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
