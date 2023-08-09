package Executavel;

import Arquivo.ArquivoJson;
import HttpRR.ConsultaClima;
import Model.Clima;
import Records.ClimaRecords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsultaClima consultaClima = new ConsultaClima();
        ArquivoJson arquivoJson = new ArquivoJson();

        List<Clima> climaList = new ArrayList<>();

        String op = " ";
        System.out.println("Digite o nome de alguma cidade: ");
        String cidade = scanner.nextLine();

       try {

            while (!op.equalsIgnoreCase("nao") || !op.equalsIgnoreCase("não")) {

                ClimaRecords climaRecords = consultaClima.urlGeolocalizacao(cidade);

                Clima clima = new Clima(climaRecords);

                clima.kelvinParaCelsius(clima.getTemperatura());
                System.out.println(clima);

                climaList.add(clima);

                System.out.println("Escolher outra cidade? \"sim\" ou \"nao\".");
                op = scanner.nextLine();

                if (op.equalsIgnoreCase("nao") || op.equalsIgnoreCase("não")) {
                    System.out.println("Encerrando.");
                    break;
                } else if (op.equalsIgnoreCase("sim")) {
                    System.out.println("Digite o nome da cidade.");
                    cidade = scanner.nextLine();
                }
            }
       }catch (IllegalArgumentException e){
            System.out.println("O valor não foi inserido corretamente/não foi encontrado.");
            e.getMessage();
       }catch (NullPointerException e){
           System.out.println("O valor inserido não é um texto.");
           e.getMessage();
       }

        System.out.println("Gerando arquivo...");
        arquivoJson.gerandoArquivoJson(climaList);
    }

}
