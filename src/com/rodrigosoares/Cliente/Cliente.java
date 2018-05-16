package com.rodrigosoares.Cliente;

import com.rodrigosoares.Pacote;
import com.rodrigosoares.Servidor.Cidade;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {

    private static Pacote pacoteDoUsuario(ArrayList<Cidade> cidades)throws Exception{
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

        System.out.println("Deseja adicionar cidades? ('sim' ou 'nao')");
        if(teclado.readLine().toUpperCase().equals("SIM")) {
            pacote.setAdicionarCidades(true);
            System.out.println("Digite o nome da cidade que deseja adicionar: (Digite 'sair' para parar)");
            Cidade cidadeAdicionada = new Cidade(teclado.readLine());

            while(!cidadeAdicionada.getNome().toUpperCase().equals("SAIR")){
                try {
                    while (true){
                        System.out.println("Digite as cidades ligadas, minimo 2 (Digite 'sair' para parar)");
                        String nomeCidadeLigada = teclado.readLine();
                        int distancia = 0;
                        Cidade cidadeLigada = new Cidade();
                        for(int i=0; i<cidades.size(); i++){
                            if(cidades.get(i).getNome().equals(nomeCidadeLigada))
                                cidadeLigada = cidades.get(i);
                        }

                        //Se digitar alguma cidade inexistente ou 'sair'
                        if(cidadeLigada.getNome() == "")
                            throw new Exception();

                        System.out.println("Qual a distancia?");
                        distancia = Integer.parseInt(teclado.readLine());

                        cidadeLigada.addRota(cidadeAdicionada, distancia);
                        cidadeAdicionada.addRota(cidadeLigada, distancia);
                        cidades.add(cidadeAdicionada);
                    }
                }catch (Exception e){}
                System.out.println("Digite o nome da cidade que deseja adicionar: (Digite 'sair' para parar)");
                cidadeAdicionada = new Cidade(teclado.readLine());
            }
            pacote.setNovasCidades(cidades);
        }
        else
            pacote.setAdicionarCidades(false);

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

            //Recebe as cidades do servidor
            ArrayList<Cidade> cidades = (ArrayList<Cidade>)receptor.readObject();

            //Capta as informacoes que usuario deseja
            Pacote pacote = pacoteDoUsuario(cidades);

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
