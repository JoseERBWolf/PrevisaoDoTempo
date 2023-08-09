package Model;

import Records.ClimaRecords;

public class Clima {

    private String cidade;
    private String codigoPais;
    private double temperatura;
    private String descricao;

    public Clima(ClimaRecords climaRecords) {
        this.cidade = climaRecords.name();
        this.codigoPais = climaRecords.sys().country();
        this.temperatura = climaRecords.main().temp();
        this.descricao = climaRecords.weather().get(0).description();
    }

    public void kelvinParaCelsius(double temperatura) {
        this.temperatura = temperatura - 273.15;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getTemperatura() {
        return temperatura;
    }


    @Override
    public String toString() {
        return "País: " + codigoPais +
                ", cidade='" + cidade +
                String.format(", temperatura: %.0f°C", temperatura) +
                ", descrição do clima: " + descricao
                ;
    }
}
