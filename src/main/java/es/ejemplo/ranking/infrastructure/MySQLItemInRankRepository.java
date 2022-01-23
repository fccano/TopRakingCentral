package es.ejemplo.ranking.infrastructure;

import es.ejemplo.ranking.domain.ItemInRankRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MySQLItemInRankRepository implements ItemInRankRepository  {
    @Override
    public List<String> searchAllLanguageItems(String language) {
        return new ArrayList<>();
    }
}
