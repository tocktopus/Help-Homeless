package br.com.helphomeless.trabalho3bimestre.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase(DoadorRepository repository){
        return args -> {
            //aqui sera colocado o codigo de insercao de dados iniciais no banco
            //inserindo doador 1 e suas doacoes
            Doador doador1 = new Doador("José Bezerra", "josebezerra@gmail.com", "coroa123");

            List<Doacao> doacoes = new ArrayList<>();

            Doacao doacao1 = new Doacao(200.00, Date.valueOf("2021-09-29"));
            doacao1.setDoador(doador1); 
            doacoes.add(doacao1); 

            Doacao doacao2 = new Doacao(100.00, Date.valueOf("2021-10-15"));
            doacao2.setDoador(doador1);
            doacoes.add(doacao2);

            doador1.setDoacoes(doacoes);

            //inserindo doador 2 e suas doacoes
            Doador doador2 = new Doador("Anna Arendelle", "anna@gmail.com", "abracosquentinhos");

            doacoes = new ArrayList<>();

            doacao1 = new Doacao(500.00, Date.valueOf("2021-09-15"));
            doacao1.setDoador(doador2);
            doacoes.add(doacao1);

            doacao2 = new Doacao(800.00, Date.valueOf("2021-10-18"));
            doacao2.setDoador(doador2);
            doacoes.add(doacao2);

            doador2.setDoacoes(doacoes);

            log.info("Preloading " + repository.save(doador1));
            log.info("Preloading " + repository.save(doador2));
        };
        
    }

}