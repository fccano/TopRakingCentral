package es.ejemplo.ranking.application;


import es.ejemplo.ranking.domain.ItemInRankRepository;
import es.ejemplo.ranking.infrastructure.CSVItemInRankRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;



public class StubTopRankingCalculatorServiceTest {

    private TopRankingCalculatorService service;

    @BeforeEach
    protected void setUp() {

        service = new TopRankingCalculatorService(new CSVItemInRankRepository());
        //TODO: Evidentemente esto no está bien. Habría que crear un repositorio específico que devuelva los valores con la lógica predefinida.
    }

    @Test
    void shouldReturnTop3Repos() {
        List<String> actualTopReposList = service.calculate("JavaScript",5);

        String repo1 = "1,top-100-stars,freeCodeCamp,296554,20629,JavaScript,https://github.com/freeCodeCamp/freeCodeCamp,freeCodeCamp,6572,2018-12-18T12:16:12Z,The https://www.freeCodeCamp.org open source codebase and curriculum. Learn to code for free together with millions of people.";
        String repo2 = "2,top-100-stars,bootstrap,129436,63583,CSS,https://github.com/twbs/bootstrap,twbs,326,2018-12-18T10:30:50Z,\"The most popular HTML, CSS, and JavaScript framework for developing responsive, mobile first projects on the web.\"";
        String repo3 = "3,top-100-stars,vue,122454,17507,JavaScript,https://github.com/vuejs/vue,vuejs,233,2018-12-18T07:38:59Z,\"\uD83D\uDD96 A progressive, incrementally-adoptable JavaScript framework for building UI on the web.";
        List<String> expectedTopReposList =  new ArrayList<>();
        expectedTopReposList.add(repo1);
        expectedTopReposList.add(repo2);
        expectedTopReposList.add(repo3);

        assertEquals(expectedTopReposList, actualTopReposList);
    }
}
