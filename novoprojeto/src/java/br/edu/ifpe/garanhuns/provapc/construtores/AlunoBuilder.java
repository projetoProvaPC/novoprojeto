/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.controladores.ControladorAluno;
import br.edu.ifpe.garanhuns.provapc.negocio.Aluno;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@RequestScoped
public class AlunoBuilder {
    private long id;
    private String matricula;
    private String nome;
    FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorAluno controlador = (ControladorAluno) faces.getApplication().evaluateExpressionGet(faces, "#{controladorAluno}", ControladorAluno.class);
    private boolean alterando = false;

    public AlunoBuilder() {
        Aluno a = controlador.getAlterando();
        if(a!=null) {
            this.id = a.getId();
            this.matricula = a.getMatricula();
            this.nome = a.getNome();
            this.alterando = true;
        }
    }

    public long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Aluno construir() {
        return new Aluno(id,matricula,nome);
    }
}