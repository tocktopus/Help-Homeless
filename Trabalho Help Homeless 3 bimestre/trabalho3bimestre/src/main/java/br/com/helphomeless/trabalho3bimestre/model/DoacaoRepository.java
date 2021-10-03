package br.com.helphomeless.trabalho3bimestre.model;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DoacaoRepository extends CrudRepository<Doacao, Long>{
    
    List<Doacao> findByData(Date data);
}