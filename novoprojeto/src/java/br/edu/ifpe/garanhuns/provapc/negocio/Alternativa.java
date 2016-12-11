/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thais
 */
@Entity
@Table
public class Alternativa implements Persistivel<Alternativa>{
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String texto;
    @Column
    private boolean veracidade;
    
    public Alternativa(){
    }

    public Alternativa(String texto, boolean veracidade) {
        this.texto = texto;
        this.veracidade = veracidade;
    }
    
    public Alternativa(long id, String texto, boolean veracidade) {
        this.id = id;
        this.texto = texto;
        this.veracidade = veracidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.texto);
        hash = 61 * hash + (this.veracidade ? 1 : 0);
        return hash;
    }
       
    public String getTexto() {
        return texto;
    }

    public boolean isVeracidade() {
        return veracidade;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setVeracidade(boolean veracidade) {
        this.veracidade = veracidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        final Alternativa other = (Alternativa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.veracidade != other.veracidade) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Alternativa{" + "id=" + id + ", texto=" + texto + ", veracidade=" + veracidade + '}';
        return texto;
    }

    @Override
    public void alterar(Alternativa t) {
        this.setTexto(t.getTexto());
        this.setVeracidade(t.isVeracidade());
    }

    @Override
    public Alternativa copiar() {
        return new Alternativa(texto, veracidade);
    }
    
        
}