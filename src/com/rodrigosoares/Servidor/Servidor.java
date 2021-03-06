package com.rodrigosoares.Servidor;

import com.rodrigosoares.Pacote;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    private static void inicializaCidades(ArrayList<Cidade> cidades) throws Exception{
        Cidade Albany= new Cidade ("Albany");
        Cidade Boston = new Cidade ("Boston");
        Cidade NovaYork = new Cidade ("Nova York");
        Cidade Washington = new Cidade("Washington");
        Cidade Richmond= new Cidade("Richmond");
        Cidade Indianapolis = new Cidade("Indianapolis");
        Cidade Chicago= new Cidade("Chicago");
        Cidade Nashville= new Cidade("Nashville");
        Cidade Milwaukee= new Cidade("Milwaukee");
        Cidade Atlanta= new Cidade("Atlanta");
        Cidade Memphis= new Cidade("Memphis");
        Cidade StLouis= new Cidade("St Louis");
        Cidade KansasCity= new Cidade("Kansas City");
        Cidade Mineapolis= new Cidade("Mineapolis");
        Cidade LittleRock= new Cidade("Little Rock");
        Cidade Dallas= new Cidade("Dallas");
        Cidade Omaha= new Cidade("Omaha");
        Cidade ColoradoSprings= new Cidade("Colorado Springs");
        Cidade Orlando= new Cidade("Orlando");
        Cidade FortLauderdale= new Cidade("Fort Lauderdale");
        Cidade Miami= new Cidade("Miami");
        Cidade NovaOrleans= new Cidade("Nova Orleans");
        Cidade Denver= new Cidade("Denver");
        Cidade Aspen= new Cidade("Aspen");
        Cidade Vail= new Cidade("Vail");
        Cidade Yellowstone= new Cidade("Yellowstone");
        Cidade SaltLakeCity= new Cidade("Salt Lake City");
        Cidade LasVegas= new Cidade("Las Vegas");
        Cidade GrandCanyon= new Cidade("Grand Canyon");
        Cidade Boise= new Cidade("Boise");
        Cidade PalmSprings = new Cidade("Palm Springs");
        Cidade Phoenix= new Cidade("Phoenix");
        Cidade SanDiego= new Cidade("San Diego");
        Cidade LosAngeles= new Cidade("Los Angeles");
        Cidade LakeTahoe= new Cidade("Lake Tahoe");
        Cidade SanFrancisco= new Cidade("San Francisco");
        Cidade Portland= new Cidade("Portland");
        Cidade Seatle= new Cidade("Seatle");
        Cidade Detroit = new Cidade("Detroit");
        Cidade SanAntonio = new Cidade("San Antonio");
        Cidade Houston = new Cidade("Houston");

        cidades.add(Houston);
        cidades.add(SanAntonio);
        cidades.add(Albany);
        cidades.add(Boston);
        cidades.add(NovaYork);
        cidades.add(Washington);
        cidades.add(Richmond);
        cidades.add(Indianapolis);
        cidades.add(Chicago);
        cidades.add(Nashville);
        cidades.add(Milwaukee);
        cidades.add(Atlanta);
        cidades.add(Memphis);
        cidades.add(StLouis);
        cidades.add(KansasCity);
        cidades.add(Mineapolis);
        cidades.add(LittleRock);
        cidades.add(Dallas);
        cidades.add(Omaha);
        cidades.add(ColoradoSprings);
        cidades.add(Orlando);
        cidades.add(FortLauderdale);
        cidades.add(Miami);
        cidades.add(NovaOrleans);
        cidades.add(Denver);
        cidades.add(Aspen);
        cidades.add(Vail);
        cidades.add(Yellowstone);
        cidades.add(SaltLakeCity);
        cidades.add(LasVegas);
        cidades.add(GrandCanyon);
        cidades.add(Boise);
        cidades.add(PalmSprings);
        cidades.add(Phoenix);
        cidades.add(SanDiego);
        cidades.add(LosAngeles);
        cidades.add(LakeTahoe);
        cidades.add(SanFrancisco);
        cidades.add(Portland);
        cidades.add(Seatle);
        cidades.add(Detroit);

        Albany.addRota(Boston, 170);
        Albany.addRota(NovaYork, 150);
        Albany.addRota(Detroit, 650);

        Boston.addRota(Albany, 170);
        Boston.addRota(NovaYork, 210);

        NovaYork.addRota(Boston, 210);
        NovaYork.addRota(Albany, 150);
        NovaYork.addRota(Detroit, 640);
        NovaYork.addRota(Washington, 240);

        Washington.addRota(NovaYork, 240);
        Washington.addRota(Detroit, 530);
        Washington.addRota(Chicago, 700);
        Washington.addRota(Indianapolis, 590);
        Washington.addRota(Richmond, 200);

        Richmond.addRota(Washington, 200);
        Richmond.addRota(Nashville, 710);
        Richmond.addRota(Atlanta, 560);

        Indianapolis.addRota(Washington, 590);
        Indianapolis.addRota(Nashville, 290);
        Indianapolis.addRota(StLouis, 250);
        Indianapolis.addRota(Chicago, 180);

        Chicago.addRota(Milwaukee, 90);
        Chicago.addRota(Detroit, 280);
        Chicago.addRota(Washington, 700);
        Chicago.addRota(Indianapolis, 180);
        Chicago.addRota(StLouis, 300);
        Chicago.addRota(Omaha, 470);
        Chicago.addRota(Mineapolis, 430);

        Nashville.addRota(Indianapolis, 290);
        Nashville.addRota(Richmond, 710);
        Nashville.addRota(Atlanta, 240);
        Nashville.addRota(Memphis, 210);

        Milwaukee.addRota(Chicago, 90);
        Milwaukee.addRota(Mineapolis, 340);

        Atlanta.addRota(Nashville, 240);
        Atlanta.addRota(Richmond, 560);
        Atlanta.addRota(Orlando, 440);
        Atlanta.addRota(NovaOrleans, 470);
        Atlanta.addRota(Memphis, 390);
        Atlanta.addRota(Dallas, 790);

        Memphis.addRota(StLouis, 290);
        Memphis.addRota(Nashville, 210);
        Memphis.addRota(Atlanta, 390);
        Memphis.addRota(LittleRock, 140);

        StLouis.addRota(Chicago, 300);
        StLouis.addRota(Indianapolis, 250);
        StLouis.addRota(Memphis, 290);
        StLouis.addRota(LittleRock, 400);
        StLouis.addRota(KansasCity, 250);

        KansasCity.addRota(Omaha, 190);
        KansasCity.addRota(StLouis, 250);
        KansasCity.addRota(Dallas, 550);


        Mineapolis.addRota(Milwaukee, 340);
        Mineapolis.addRota(Chicago, 430);
        Mineapolis.addRota(Omaha, 380);
        Mineapolis.addRota(Yellowstone, 1340);

        LittleRock.addRota(StLouis, 400);
        LittleRock.addRota(Memphis, 140);
        LittleRock.addRota(Dallas, 320);

        Dallas.addRota(LittleRock, 320);
        Dallas.addRota(KansasCity, 550);
        Dallas.addRota(Atlanta, 790);
        Dallas.addRota(Houston, 250);
        Dallas.addRota(SanAntonio, 280);
        Dallas.addRota(Phoenix, 1070);
        Dallas.addRota(ColoradoSprings, 730);

        Omaha.addRota(Chicago, 470);
        Omaha.addRota(KansasCity, 250);
        Omaha.addRota(Denver, 250);
        Omaha.addRota(Mineapolis, 380);

        ColoradoSprings.addRota(Denver, 120);
        ColoradoSprings.addRota(Dallas, 730);
        ColoradoSprings.addRota(Aspen, 180);

        Orlando.addRota(Atlanta, 440);
        Orlando.addRota(FortLauderdale, 180);
        Orlando.addRota(Miami, 230);
        Orlando.addRota(NovaOrleans, 640);

        FortLauderdale.addRota(Miami, 30);
        FortLauderdale.addRota(Orlando, 180);

        Miami.addRota(FortLauderdale, 30);
        Miami.addRota(Orlando, 230);
        Miami.addRota(NovaOrleans, 860);

        NovaOrleans.addRota(Atlanta, 470);
        NovaOrleans.addRota(Orlando, 640);
        NovaOrleans.addRota(Miami, 860);
        NovaOrleans.addRota(Houston, 530);

        Denver.addRota(Yellowstone, 930);
        Denver.addRota(Omaha, 540);
        Denver.addRota(ColoradoSprings, 120);
        Denver.addRota(Aspen, 170);
        Denver.addRota(Vail, 160);
        Denver.addRota(SaltLakeCity, 530);

        Aspen.addRota(Vail, 80);
        Aspen.addRota(Denver, 170);
        Aspen.addRota(ColoradoSprings, 180);

        Vail.addRota(Denver, 160);
        Vail.addRota(Aspen, 80);

        Yellowstone.addRota(Mineapolis, 1340);
        Yellowstone.addRota(Boise, 670);
        Yellowstone.addRota(Denver, 930);

        SaltLakeCity.addRota(Denver, 530);
        SaltLakeCity.addRota(Phoenix, 660);
        SaltLakeCity.addRota(LasVegas, 420);
        SaltLakeCity.addRota(LakeTahoe, 520);

        LasVegas.addRota(SaltLakeCity, 420);
        LasVegas.addRota(GrandCanyon, 470);
        LasVegas.addRota(PalmSprings, 290);
        LasVegas.addRota(LosAngeles, 270);

        GrandCanyon.addRota(Phoenix, 360);
        GrandCanyon.addRota(PalmSprings, 440);
        GrandCanyon.addRota(LasVegas, 470);

        Boise.addRota(Yellowstone, 670);
        Boise.addRota(LakeTahoe, 420);
        Boise.addRota(Portland, 420);
        Boise.addRota(Seatle, 500);

        PalmSprings.addRota(LasVegas, 290);
        PalmSprings.addRota(GrandCanyon, 440);
        PalmSprings.addRota(SanDiego, 140);
        PalmSprings.addRota(LosAngeles, 160);

        Phoenix.addRota(SaltLakeCity, 660);
        Phoenix.addRota(Dallas, 1070);
        Phoenix.addRota(SanAntonio, 990);
        Phoenix.addRota(SanDiego, 350);
        Phoenix.addRota(GrandCanyon, 360);

        SanDiego.addRota(LosAngeles, 120);
        SanDiego.addRota(PalmSprings, 140);
        SanDiego.addRota(Phoenix, 350);

        LosAngeles.addRota(SanFrancisco, 380);
        LosAngeles.addRota(LasVegas, 270);
        LosAngeles.addRota(PalmSprings, 160);
        LosAngeles.addRota(SanDiego, 120);

        LakeTahoe.addRota(Portland, 580);
        LakeTahoe.addRota(Boise, 420);
        LakeTahoe.addRota(SaltLakeCity, 520);
        LakeTahoe.addRota(PalmSprings, 780);
        LakeTahoe.addRota(SanFrancisco, 300);

        SanFrancisco.addRota(Portland, 640);
        SanFrancisco.addRota(LakeTahoe, 300);
        SanFrancisco.addRota(LosAngeles, 380);

        Portland.addRota(Seatle, 170);
        Portland.addRota(Boise, 420);
        Portland.addRota(LakeTahoe, 580);
        Portland.addRota(SanFrancisco, 640);

        Seatle.addRota(Boise, 500);
        Seatle.addRota(Portland, 170);

        Detroit.addRota(Albany, 650);
        Detroit.addRota(NovaYork, 640);
        Detroit.addRota(Washington, 530);
        Detroit.addRota(Chicago, 280);

        SanAntonio.addRota(Dallas, 280);
        SanAntonio.addRota(Houston, 310);
        SanAntonio.addRota(Phoenix, 990);

        Houston.addRota(Dallas, 250);
        Houston.addRota(NovaOrleans, 530);
        Houston.addRota(SanAntonio, 310);
    }

    public static void main(String[] args) {
        try {
            //Recebe a conexão
            ServerSocket pedido = new ServerSocket(9090);
            Socket conexao = pedido.accept();
            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
            ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());

            //Variaveis auxiliares
            Pacote pacote = null;
            ArrayList<Cidade> enviadas = new ArrayList<Cidade>() ;
            ArrayRotas menorRota = new ArrayRotas();

            //Inicializa o mapa
            Mapa mapa;
            ArrayList<Cidade> cidades = new ArrayList<>();
            inicializaCidades(cidades);

            //Envia o mapa para o cliente
            transmissor.writeObject(cidades);

            //Recebe o pacote enviado pelo socket
            pacote = (Pacote)receptor.readObject();
            if(pacote.getAdicionarCidades())
                cidades = pacote.getNovasCidades();

            //Inicializa o mapa apos receber as cidades do cliente
            mapa = new Mapa (cidades);

            //Identifica as cidades
            for(int i=0; i<pacote.getNomeCidades().size(); i++){
                enviadas.add(mapa.getCidade(pacote.getNomeCidades().get(i)));
            }

            //Printa que a busca esta sendo efetuada
            System.out.println("Efetuando a busca...");

            //Busca a menor rota de acordo com a cidade enviada
            if(enviadas.size()==1)
                menorRota = mapa.menorRota(enviadas.get(0).getNome(), pacote.getTempoDeBusca(), pacote.isSomenteIda());
            else
                menorRota = mapa.menorRota(enviadas.get(0).getNome(), enviadas, pacote.getTempoDeBusca(), pacote.isSomenteIda());

            //Envia o resultado
            String enviado =""; //"["+cidade;
            for (int i = 0; i < menorRota.size(); i++) {
                enviado += " --"+menorRota.get(i).getDistancia()+ "--> " + menorRota.get(i).getDestino().getNome();
            }
            enviado+="]\nTotal: "+menorRota.getDistancia();
            transmissor.writeObject(enviado);

            //Fecha conexao
            pedido.close();
            conexao.close();
            receptor.close();

        }
        catch (Exception e ){
            System.err.println(e.getMessage());
        }
    }
}
