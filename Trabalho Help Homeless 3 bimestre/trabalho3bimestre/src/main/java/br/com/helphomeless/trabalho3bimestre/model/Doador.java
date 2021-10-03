package br.com.helphomeless.trabalho3bimestre.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doador {

    //criando uma variavel id que sera a chave primaria da classe
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoador;
    private String nome;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Doacao>doacoes;

    //construtores
    public Doador() {
    }

    public Doador(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //getters e setters
    public Long getIdDoador() {
        return this.idDoador;
    }

    public void setIdDoador(Long idDoador) {
        this.idDoador = idDoador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }
    public void addDoacao(Doacao doacao){
        doacoes.add(doacao);
    }
}
