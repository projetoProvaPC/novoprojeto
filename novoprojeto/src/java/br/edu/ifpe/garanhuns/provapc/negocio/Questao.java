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
    private double pontuaçao;
    @Column
    private int tamanhoEspaço;
    
    @OneToMany
    List<Alternativa> Alternativa= new ArrayList<>();
    
     
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

    public double getPontuaçao() {
        return pontuaçao;
    }

    public int getTamanhoEspaço() {
        return tamanhoEspaço;
    }

    public List<Alternativa> getAlternativa() {
        return Alternativa;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setPontuaçao(double pontuaçao) {
        this.pontuaçao = pontuaçao;
    }

    public void setTamanhoEspaço(int tamanhoEspaço) {
        this.tamanhoEspaço = tamanhoEspaço;
    }

    public void setAlternativa(List<Alternativa> Alternativa) {
        this.Alternativa = Alternativa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.enunciado);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.pontuaçao) ^ (Double.doubleToLongBits(this.pontuaçao) >>> 32));
        hash = 97 * hash + this.tamanhoEspaço;
        hash = 97 * hash + Objects.hashCode(this.Alternativa);
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
        if (Double.doubleToLongBits(this.pontuaçao) != Double.doubleToLongBits(other.pontuaçao)) {
            return false;
        }
        if (this.tamanhoEspaço != other.tamanhoEspaço) {
            return false;
        }
        if (!Objects.equals(this.enunciado, other.enunciado)) {
            return false;
        }
        if (!Objects.equals(this.Alternativa, other.Alternativa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", enunciado=" + enunciado + ", pontua\u00e7ao=" + pontuaçao + ", tamanhoEspa\u00e7o=" + tamanhoEspaço + ", Alternativa=" + Alternativa + '}';
    }
    
    
    
}
            