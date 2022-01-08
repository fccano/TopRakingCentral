package es.ejemplo.ranking;

import es.ejemplo.ranking.domain.ItemInRankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class RankingApplicationUnitTestCase {

    @Mock
    protected ItemInRankRepository mockedItemInRankRepository;

    @BeforeEach
    protected void setUp() {
        mockedItemInRankRepository = mock(ItemInRankRepository.class);
    }
}
