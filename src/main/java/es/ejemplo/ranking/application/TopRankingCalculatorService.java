package es.ejemplo.ranking.application;

import es.ejemplo.ranking.domain.ItemInRankRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopRankingCalculatorService {
    ItemInRankRepository repository;

    public TopRankingCalculatorService(ItemInRankRepository repository){
        this.repository = repository;
    }

    public final List<String> calculate(String language, int maxInRank) {

        List<String> reposDelLenguajeBuscado = repository.searchAllLanguageItems(language);

        return reposDelLenguajeBuscado.stream().limit(maxInRank).collect(Collectors.toList());

    }
}
