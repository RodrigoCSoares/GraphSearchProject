package com.rodrigosoares.Cliente;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String args[]){
        try{
            Socket conexao = new Socket("127.0.0.1",32123);
            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String mensagem;

            do {
                mensagem = teclado.readLine();
                transmissor.flush();
            }while (mensagem.toUpperCase()!="SAIR");

            transmissor.close();
            conexao.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
