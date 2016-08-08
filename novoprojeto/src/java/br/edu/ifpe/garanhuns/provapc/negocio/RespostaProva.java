/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Column
    private Prova prova;

    @MapKey
    @MapKeyClass(Questao.class)
    @OneToMany(cascade = CascadeType.ALL)
    private final Map<Questao, RespostaQuestao> respostas;

    public RespostaProva(long id, Prova prova) {
        this.id = id;
        this.prova = prova;
        this.respostas = new HashMap<>();
    }

    public RespostaProva(Prova prova) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
