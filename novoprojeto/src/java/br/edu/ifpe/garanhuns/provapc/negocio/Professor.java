/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thais, Lucinaldo Melquíades Jr.
 */
@Entity
@Table
public class Professor implements Persistivel<Professor>{
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private int siape;
    @Column
    private String nome;

    public Professor(long id, int siap, String nome) {
        this.id = id;
        this.siape = siap;
        this.nome = nome;
    }

    public Professor(int siap, String nome) {
        this.siape = siap;
        this.nome = nome;
    }

    public Professor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + this.siape;
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
        final Professor other = (Professor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.siape != other.siape) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", siap=" + siape + '}';
    }

    @Override
    public void alterar(Professor t) {
        this.setSiape(t.getSiape());
        this.setNome(t.getNome());
    }

    @Override
    public Professor copiar() {
        return new Professor (siape,nome);
    }
    
    
    
}
