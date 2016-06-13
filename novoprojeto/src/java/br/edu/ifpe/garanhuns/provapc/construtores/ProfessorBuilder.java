/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.controladores.ControladorProfessor;
import br.edu.ifpe.garanhuns.provapc.negocio.Professor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@RequestScoped
public class ProfessorBuilder {
    private long id;
    private int siape;
    private String nome;
    FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorProfessor controlador = (ControladorProfessor) faces.getApplication().evaluateExpressionGet(faces, "#{controladorProfessor}", ControladorProfessor.class);
    private boolean alterando = false;

    public ProfessorBuilder() {
        Professor p = controlador.getAlterando();
        if(p!=null) {
            this.id = p.getId();
            this.siape = p.getSiape();
            this.nome = p.getNome();
            this.alterando = true;
        }
    }

    public long getId() {
        return id;
    }

    public int getSiape() {
        return siape;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Professor construir() {
        return new Professor(id,siape,nome);
    }
}
