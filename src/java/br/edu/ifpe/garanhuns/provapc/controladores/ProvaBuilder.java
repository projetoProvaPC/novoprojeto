/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Prova;
import br.edu.ifpe.garanhuns.provapc.model.Questao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Thais
 */
@ManagedBean
@RequestScoped
public class ProvaBuilder {
    
    private long id;
    private String titulo;
    private boolean alterando = false;
    List<QuestaoBuilder> questoes = new ArrayList<>();

    public ProvaBuilder() {
        
    }

    public ProvaBuilder(Prova selected) {
        this.id = selected.getId();
        this.titulo = selected.getTitulo();
        this.alterando = true;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public boolean isAlterando() {
        return alterando;
    }

    public void setAlterando(boolean alterando) {
        this.alterando = alterando;
    }

    public List<QuestaoBuilder> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoBuilder> questoes) {
        this.questoes = questoes;
    }

    public boolean addQuestao(QuestaoBuilder e) {
        return questoes.add(e);
    }

    public boolean removeQuestao(QuestaoBuilder o) {
        return questoes.remove(o);
    }
    
    
    public Prova construir(){
        Prova novaProva = new Prova(id,titulo);
        for(QuestaoBuilder q : this.questoes){
            Questao qu = q.construir();
            qu.setProva(novaProva);
            novaProva.adicionarQuestao(qu);
        }
        return novaProva;
        
    }

    
}
