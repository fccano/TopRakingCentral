package es.ejemplo.ranking.application;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopRankingCalculatorService {

    public final List<String> calculate(String language, int maxInRank){
        String repo1 = "1,top-100-stars,freeCodeCamp,296554,20629,JavaScript,https://github.com/freeCodeCamp/freeCodeCamp,freeCodeCamp,6572,2018-12-18T12:16:12Z";
        String repo2 = "2,top-100-stars,bootstrap,129436,63583,CSS,https://github.com/twbs/bootstrap,twbs,326,2018-12-18T10:30:50Z";
        String repo3 = "3,top-100-stars,vue,122454,17507,JavaScript,https://github.com/vuejs/vue,vuejs,233,2018-12-18T07:38:59";

        List<String> popularReposList =  new ArrayList<>();
        popularReposList.add(repo1);
        popularReposList.add(repo2);
        popularReposList.add(repo3);

        return popularReposList;
    }
}
