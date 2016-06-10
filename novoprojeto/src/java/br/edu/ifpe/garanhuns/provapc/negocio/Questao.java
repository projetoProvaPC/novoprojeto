/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Questao {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String enunciado;
    @Column
    private double pontuacao;
    @Column
    private int tamanhoEspaco;
    
    @OneToMany
    private List<Alternativa> alternativas= new ArrayList<>();

    public Questao(String enunciado, double pontuacao, int tamanhoEspaco) {
        this.enunciado = enunciado;
        this.pontuacao = pontuacao;
        this.tamanhoEspaco = tamanhoEspaco;
    }
    
    public void adicionarAlternativa(Alternativa a){
        alternativas.add(a);
    }
    public void removerAlternativa(Alternativa a){
        alternativas.remove(a);
    } 
    public long getId() {
        return id;
    }
    

    public void setId(long id) {
        this.id = id;
    }

    public Questao() {
    }

    public String getEnunciado() {
        return enunciado;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public int getTamanhoEspaco() {
        return tamanhoEspaco;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setPontuacao(double pontuaçao) {
        this.pontuacao = pontuaçao;
    }

    public void setTamanhoEspaco(int tamanhoEspaço) {
        this.tamanhoEspaco = tamanhoEspaço;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.enunciado);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.pontuacao) ^ (Double.doubleToLongBits(this.pontuacao) >>> 32));
        hash = 97 * hash + this.tamanhoEspaco;
        hash = 97 * hash + Objects.hashCode(this.alternativas);
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
        final Questao other = (Questao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.pontuacao) != Double.doubleToLongBits(other.pontuacao)) {
            return false;
        }
        if (this.tamanhoEspaco != other.tamanhoEspaco) {
            return false;
        }
        if (!Objects.equals(this.enunciado, other.enunciado)) {
            return false;
        }
        if (!Objects.equals(this.alternativas, other.alternativas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", enunciado=" + enunciado + ", pontuacao=" + pontuacao + ", tamanhoEspaco=" + tamanhoEspaco + ", Alternativa=" + alternativas + '}';
    }
    
    
    
}
            
