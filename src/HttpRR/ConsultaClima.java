package HttpRR;

import Records.ClimaRecords;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaClima {

    public ClimaRecords urlGeolocalizacao(String cidade){

        Chave chave = new Chave();

        URI endereco = URI.create("https://api.openweathermap.org/data/2.5/weather?q=" + cidade +
                "&appid=" + chave.getChave() + "&lang=pt_br");

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();



            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ClimaRecords.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
