package es.ejemplo.ranking.application;

import es.ejemplo.ranking.domain.ItemInRankRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TopRankingCalculatorService {
    ItemInRankRepository repository;

    public TopRankingCalculatorService(ItemInRankRepository repository){
        this.repository = repository;
    }

    public final List<String> calculate(String language, int maxInRank) {

        List<String> reposDelLenguajeBuscado = repository.searchAllLanguageItems(language);

        //TODO: Mejorar este condicional
        if (maxInRank > reposDelLenguajeBuscado.size()) {
            return reposDelLenguajeBuscado.subList(0, reposDelLenguajeBuscado.size()-1);
        } else {
            return reposDelLenguajeBuscado.subList(0, maxInRank);
        }
    }
}
