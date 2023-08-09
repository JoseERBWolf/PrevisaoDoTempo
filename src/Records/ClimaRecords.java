package Records;

import java.util.List;

public record ClimaRecords(String name, Localizacao sys, Temperatura main, List<DescricaoClima> weather) {
}
