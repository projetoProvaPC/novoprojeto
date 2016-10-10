/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
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
public class RespostaProva implements Persistivel<RespostaProva> {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne (cascade = CascadeType.ALL, targetEntity = Prova.class, fetch = FetchType.EAGER)
    private Prova prova;

    @MapKey
    @MapKeyClass(Questao.class)
    @OneToMany(cascade = CascadeType.ALL)
    private final Map<Questao, RespostaQuestao> respostas;
  
    public RespostaProva() {
        this.respostas = new HashMap<>();
    }

    public RespostaProva(long id, Prova prova) {
        this.id = id;
        this.prova = prova;
        this.respostas = new HashMap<>();
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

    @Override
    public void alterar(RespostaProva t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
}
