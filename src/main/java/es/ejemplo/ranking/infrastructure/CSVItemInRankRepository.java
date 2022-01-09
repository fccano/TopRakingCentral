package es.ejemplo.ranking.infrastructure;

import es.ejemplo.ranking.domain.ItemInRankRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class CSVItemInRankRepository implements ItemInRankRepository {

    @Override
    public List<String> searchAllLanguageItems(String language) {
        List<String> listadoReposLenguaje = new ArrayList<>();
        try {


            ProcessBuilder processBuilder;

            String comandoShellAEjecutar = "head -100 github-ranking-2018-12-18.csv | awk -F ',' '$6 == \"" + language + "\"'";
            log.info(comandoShellAEjecutar);
            processBuilder = new ProcessBuilder("/bin/sh", "-c", comandoShellAEjecutar);
            Process process = processBuilder.start();

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String commandRead;
            while ((commandRead = stdInput.readLine()) != null) {
                listadoReposLenguaje.add(commandRead);
                log.info(commandRead);
            }
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((commandRead = stdError.readLine()) != null) {
                log.info(commandRead);
            }



        } catch (IOException e) {
            e.printStackTrace();

        }
        return listadoReposLenguaje;
    }
}
