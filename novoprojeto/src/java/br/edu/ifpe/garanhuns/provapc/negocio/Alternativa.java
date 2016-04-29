/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

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
public class Alternativa {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String texto;
    @Column
    private boolean veracidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
