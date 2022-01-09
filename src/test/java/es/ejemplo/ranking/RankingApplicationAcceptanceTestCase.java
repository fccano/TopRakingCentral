package es.ejemplo.ranking;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RankingApplicationAcceptanceTestCase {
//He sacado el ejemplo de https://spring.io/guides/gs/testing-web/
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200() throws Exception {
        this.mockMvc.perform(get("/ranking/top?language=JavaScript&maxInRank=6")).andDo(print()).andExpect(status().isOk());
                //.andExpect(content().string(containsString("Hello, World")));
    }
}
