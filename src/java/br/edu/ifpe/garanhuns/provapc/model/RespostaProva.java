/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thais
 */
@Entity
@Table
public class RespostaProva {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne (cascade = CascadeType.ALL, targetEntity = Prova.class, fetch = FetchType.EAGER)
    private Prova prova;
    
    @Column(name="nomealuno")
    private String nomeAluno;
    
    @MapKey
    @MapKeyClass(Questao.class)
    @OneToMany(cascade = CascadeType.ALL)
    private final Map<Questao, RespostaQuestao> respostas;

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
  
    
    public RespostaProva() {
        this.respostas = new HashMap<>();
    }

    public RespostaProva(long id, Prova prova, String nomeAluno) {
        this.id = id;
        this.prova = prova;
        this.respostas = new HashMap<>();
        this.nomeAluno = nomeAluno;
    }

    public RespostaProva(Prova prova) {
        this();
        this.prova = prova;
    }

    public double calculaPontuaçao() {
        return 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void adicionar(RespostaQuestao q) {
        respostas.put(q.getQuestao(), q);
    }

    public void alterar(RespostaProva t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RespostaProva copiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }
     public List<RespostaQuestao> recuperaQuestao(){
        return new LinkedList<>(this.respostas.values());
    }
     
     public double resultado(){
         double soma = 0;
         for(RespostaQuestao rq : this.respostas.values()) {
             soma += rq.calcularPontuacao();
         }
         return soma;
     }
}
