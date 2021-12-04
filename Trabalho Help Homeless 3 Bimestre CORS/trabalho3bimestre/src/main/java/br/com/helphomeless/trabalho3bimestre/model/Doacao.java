package br.com.helphomeless.trabalho3bimestre.model;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Doacao {

    //criando uma variavel id que sera a chave primaria da classe
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoacao;
    private double valor;
    private HashMap<String, Integer> recursos = new HashMap<>();
    private Date data;
    //criando a chave estrangeira que fara o relacionamento com o doador
    @ManyToOne
    @JoinColumn(name = "doador_fk")
    @JsonBackReference
    private Doador doador;
    
    //construtores
    public Doacao(){

    }

    public Doacao(double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    //getters e setters
    public Long getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Long idDoacao) {
        this.idDoacao = idDoacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public HashMap<String, Integer> getRecursos() {
        return recursos;
    }

    public void setRecursos(HashMap<String, Integer> recursos) {
        this.recursos = recursos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }
    

    
}
