package es.ejemplo.ranking.domain;

import java.util.List;

public interface ItemInRankRepository {
   List<String> searchAllLanguageItems(String language);
}
