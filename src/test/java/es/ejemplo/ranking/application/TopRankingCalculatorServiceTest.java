package es.ejemplo.ranking.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TopRankingCalculatorServiceTest {

    TopRankingCalculatorService service;

    @BeforeEach
    protected void setUp() {


        service = new TopRankingCalculatorService();
    }
    @Test
    void shouldReturnTop3Repos() {
        List<String> actualTopResposList = service.calculate("javaScript",5);
        //TODO: Atención, estamos obviando los parámetros

        String repo1 = "1,top-100-stars,freeCodeCamp,296554,20629,JavaScript,https://github.com/freeCodeCamp/freeCodeCamp,freeCodeCamp,6572,2018-12-18T12:16:12Z";
        String repo2 = "2,top-100-stars,bootstrap,129436,63583,CSS,https://github.com/twbs/bootstrap,twbs,326,2018-12-18T10:30:50Z";
        String repo3 = "3,top-100-stars,vue,122454,17507,JavaScript,https://github.com/vuejs/vue,vuejs,233,2018-12-18T07:38:59";

        List<String> expectedTopResposList =  new ArrayList<>();
        expectedTopResposList.add(repo1);
        expectedTopResposList.add(repo2);
        expectedTopResposList.add(repo3);

        assertEquals(expectedTopResposList,actualTopResposList);
    }
}
