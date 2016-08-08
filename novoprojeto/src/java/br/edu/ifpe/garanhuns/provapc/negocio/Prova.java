/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thais
 */
@Entity
@Table
public class Prova implements Persistivel<Prova> {
    @Id
    @GeneratedValue
    long id;
    @Column
    private String titulo;
    
    @OneToMany ( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Questao> questoes = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prova() {
    }

    public Prova(String titulo) {
        this.titulo = titulo;
    }
    
    public Prova(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    
    public void adicionarQuestao(Questao q){
        questoes.add(q);
    }
    
    public void removerQuestao(Questao q){
        questoes.remove(q);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.titulo);
        hash = 71 * hash + Objects.hashCode(this.questoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prova other = (Prova) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.questoes, other.questoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prova{" + "id=" + id + ", titulo=" + titulo + ", Questao=" + questoes + '}';
    }

    @Override
    public void alterar(Prova t) {
        this.setTitulo(t.getTitulo());
    }

    @Override
    public Prova copiar() {
        Prova p = new Prova(id, titulo);
        for(Questao q : questoes) {
            p.adicionarQuestao(q.copiar());
        }
        return p;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
    
}
