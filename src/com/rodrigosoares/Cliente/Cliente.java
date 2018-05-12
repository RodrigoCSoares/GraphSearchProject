package com.rodrigosoares.Cliente;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String args[]){
        try{
            Socket conexao = new Socket("127.0.0.1",9090);
            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String mensagem;

            mensagem = teclado.readLine();
            transmissor.writeObject(mensagem);
            transmissor.flush();

            System.out.println((String)receptor.readObject());

            receptor.close();
            transmissor.close();
            conexao.close();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
