package es.ejemplo.ranking.application;

import es.ejemplo.ranking.RankingApplicationUnitTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class MockTopRankingCalculatorServiceTest extends RankingApplicationUnitTestCase {

    private TopRankingCalculatorService topRankingCalculatorService;

    @BeforeEach
    protected void setUp() {
        super.setUp(); //Al llamar al super se inicializa el mock del repo

        topRankingCalculatorService = new TopRankingCalculatorService(mockedItemInRankRepository);
    }

    @Test
    void shouldReturnTopRepo() {
        String repo1 = "1,top-100-stars,freeCodeCamp,296554,20629,JavaScript,https://github.com/freeCodeCamp/freeCodeCamp,freeCodeCamp,6572,2018-12-18T12:16:12Z";
      //  String repo2 = "2,top-100-stars,bootstrap,129436,63583,CSS,https://github.com/twbs/bootstrap,twbs,326,2018-12-18T10:30:50Z";
        String repo3 = "3,top-100-stars,vue,122454,17507,JavaScript,https://github.com/vuejs/vue,vuejs,233,2018-12-18T07:38:59";
        String repo4 = "4,top-100-stars,react,117818,21368,JavaScript,https://github.com/facebook/react,facebook,516,2018-12-18T01:58:28Z,\"A declarative, efficient, and flexible JavaScript library for building user interfaces.\"\n";


        List<String> expectedTopReposList =  new ArrayList<>();
        expectedTopReposList.add(repo1);
       // expectedTopReposList.add(repo2); //Este no lo añadimos porque no es de tipo JavaScript y no queremos que lo devuelva el repo para este test.
        expectedTopReposList.add(repo3);
        expectedTopReposList.add(repo4);

        //Hasta aquí definimos lo que hace el mock en este test en concreto, que es devolver "todos" los repos JavaScript
        when(mockedItemInRankRepository.searchAllLanguageItems("JavaScript")).thenReturn(expectedTopReposList);

        //Ahora llamamos al Servicio de Aplicación pidiendole que nos devuelva los de tipo
        List<String> repoJavaScriptConMasEstrellas = topRankingCalculatorService.calculate("JavaScript",1);

        //Comprobamos que lo que devuelve el servicio de aplicación es lo que esperamos, es decir, el repo1.
        Assertions.assertEquals(repo1,repoJavaScriptConMasEstrellas.get(0));

    }

}
