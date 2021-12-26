package es.ejemplo.ranking.infrastructure;

import es.ejemplo.ranking.application.TopRankingCalculatorService;
import es.ejemplo.ranking.domain.Repo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public final class RankingController {

    private final TopRankingCalculatorService topRankingCalculatorService;

    public RankingController(TopRankingCalculatorService topRankingCalculatorService) {
        this.topRankingCalculatorService = new TopRankingCalculatorService();
        //TODO: Habría que conseguir inyectar este Servicio, no instanciar aquí
    }

    @GetMapping("/top")
    @ResponseBody
    public List<String> getTopPopularRepos(@RequestParam String language, @RequestParam int maxInRank) {
        return topRankingCalculatorService.calculate(language,maxInRank);
    }


}
