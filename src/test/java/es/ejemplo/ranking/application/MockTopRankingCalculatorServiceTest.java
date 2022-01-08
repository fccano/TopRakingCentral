package es.ejemplo.ranking.application;

import es.ejemplo.ranking.domain.ItemInRankRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MockTopRankingCalculatorServiceTest {

    @Mock
    private ItemInRankRepository mockedItemInRankRepository;

    @InjectMocks
    private TopRankingCalculatorService topRankingCalculatorService;

    @Test
    void shouldReturnTopRepo() {
        String repo1 = "1,top-100-stars,freeCodeCamp,296554,20629,JavaScript,https://github.com/freeCodeCamp/freeCodeCamp,freeCodeCamp,6572,2018-12-18T12:16:12Z";
        String repo2 = "2,top-100-stars,bootstrap,129436,63583,CSS,https://github.com/twbs/bootstrap,twbs,326,2018-12-18T10:30:50Z";
        String repo3 = "3,top-100-stars,vue,122454,17507,JavaScript,https://github.com/vuejs/vue,vuejs,233,2018-12-18T07:38:59";

        List<String> expectedTopReposList =  new ArrayList<>();
        expectedTopReposList.add(repo1);
        expectedTopReposList.add(repo2);
        expectedTopReposList.add(repo3);

        //Definimos lo que hace el mock, que es devolver "todos" los repos JavaScript
        when(mockedItemInRankRepository.searchAllLanguageItems("JavaScript")).thenReturn(expectedTopReposList);

        //Ahora llamamos al Servicio de Aplicación
        List<String> repoJavaScriptConMasEstrellas = topRankingCalculatorService.calculate("JavaScript",1);

        //Comprobamos que lo que devuelve el servicio de aplicación es lo que esperamos, es decir, el repo1.
        Assertions.assertEquals(repo1,repoJavaScriptConMasEstrellas.get(0));

    }
}
