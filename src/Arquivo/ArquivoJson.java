package Arquivo;

import Model.Clima;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoJson {

    public void gerandoArquivoJson(List<Clima> climaList) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter arquivo = new FileWriter("PrevisaoDoTempo.json");
        arquivo.write(gson.toJson(climaList));
        arquivo.close();

    }

}
