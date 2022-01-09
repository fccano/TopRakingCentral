package es.ejemplo.ranking.infrastructure;

import es.ejemplo.ranking.application.TopRankingCalculatorService;
import es.ejemplo.ranking.domain.ItemInRank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ranking")
public final class RankingController {

    private final TopRankingCalculatorService topRankingCalculatorService;

    public RankingController(TopRankingCalculatorService topRankingCalculatorService) {
        this.topRankingCalculatorService = new TopRankingCalculatorService(new CSVItemInRankRepository());
        //TODO: Habría que conseguir inyectar este Servicio, no instanciar aquí
    }

    @GetMapping("/top")
    @ResponseBody
    public List<String> getTopPopularRepos(@RequestParam String language, @RequestParam int maxInRank) {
        return topRankingCalculatorService.calculate(language,maxInRank);
    }

    //Se puede invocar así: http://localhost:8080/ranking/jsonTop?language=JavaScript&maxInRank=2
    @GetMapping("/jsonTop")
    @ResponseBody
    public List<HashMap<String, String>>  getJsonTopPopularRepos(@RequestParam String language, @RequestParam int maxInRank) {
        List<String> topRespuesta = topRankingCalculatorService.calculate(language,maxInRank);

        return topRespuesta.stream().map(response -> new HashMap<String, String>() {{
            put("repo", response);

        }}).collect(Collectors.toList());
    }


}
