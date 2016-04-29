package br.edu.ifpe.garanhuns.provapc.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thais
 */
@Entity
@Table
public class Aluno {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String matricula;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
