package br.com.helphomeless.trabalho3bimestre.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.helphomeless.trabalho3bimestre.model.Doacao;
import br.com.helphomeless.trabalho3bimestre.model.DoacaoRepository;
import br.com.helphomeless.trabalho3bimestre.model.Doador;
import br.com.helphomeless.trabalho3bimestre.model.DoadorRepository;

@RestController
public class DoadorController {

    private static final Logger log = LoggerFactory.getLogger(DoadorController.class);
    
    @Autowired
    DoadorRepository doadorRepository;
    @Autowired
    DoacaoRepository doacaoRepository;

    //recuperando a lista com todos os doadores
    @GetMapping("/doadores")
    public List<Doador> getDoadores(){
        return (List<Doador>) doadorRepository.findAll();
    } 

    //recuperando um doador especifico
    @GetMapping("/doadores/{idDoador}")
        @ResponseBody
        public Doador getDoadorById(@PathVariable("idDoador") Doador doador){
            return doador;
    }

    //cadastrando um novo doador
    @PostMapping("/doadores/cadastrarDoador")
    public Doador postDoador(@RequestBody Doador doador){
        doadorRepository.save(doador);
            if(doadorRepository.findById(doador.getIdDoador()).isPresent())
                return doador;
        return null;
    }
    
    //deletando um doador
    @DeleteMapping("/doadores/deletarDoador/{idDoador}")
    public Doador deleteDoador(@PathVariable Long idDoador){
        if(doadorRepository.findById(idDoador).isPresent()){
            Doador doador = doadorRepository.findById(idDoador).get();
            doadorRepository.delete(doador);
            return doador;
        }
        return null;
    }

    //alterando os dados de um doador
    @PutMapping("/doadores/alterarDoador/{idDoador}")
    public Doador putDoador(@PathVariable Long idDoador, @RequestBody Doador doador){
        if(doadorRepository.findById(idDoador).isPresent()){
            Doador doadorBanco = doadorRepository.findById(idDoador).get();
            doadorBanco.setNome(doador.getNome());
            doadorBanco.setEmail(doador.getEmail());
            doadorBanco.setSenha(doador.getSenha());
            doadorRepository.save(doadorBanco);
            return doador;
        }
        return null;
    }

    //criando uma nova doacao
    @PostMapping("/doadores/{idDoador}/efetuarDoacao")
    public Doacao postDoacaoToDoador(@PathVariable Long idDoador, @RequestBody Doacao doacao){
        if(doadorRepository.findById(idDoador).isPresent()){
            Doador doador = doadorRepository.findById(idDoador).get();
            log.debug(doador.getNome());
            doacao.setDoador(doador);
            doacao = doacaoRepository.save(doacao);
            return doacao;
        }
        return null;
    }

    //deletando uma doacao
    @DeleteMapping("/doadores/deletarDoacao/{idDoacao}")
    public Doacao deleteDoacao(@PathVariable Long idDoacao){
        if(doacaoRepository.findById(idDoacao).isPresent()){
            Doacao doacao = doacaoRepository.findById(idDoacao).get();
            doacaoRepository.delete(doacao);
            return doacao;
        }
        return null;
    }

    //alterando uma doacao
    @PutMapping("/doadores/alterarDoacao/{idDoacao}")
    public Doacao putDoacao(@PathVariable Long idDoacao, @RequestBody Doacao doacao){
        if(doacaoRepository.findById(idDoacao).isPresent()){
            Doacao doacaoBanco = doacaoRepository.findById(idDoacao).get();
            doacaoBanco.setValor(doacao.getValor());
            doacaoBanco.setData(doacao.getData());
            doacaoRepository.save(doacaoBanco);
            return doacao;
        }
        return null;
    }    
}
