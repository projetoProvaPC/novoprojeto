/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import java.util.ArrayList;
import java.util.List;
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
    
    
}
            
