/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Professor;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProfessor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@SessionScoped
public class ControladorProfessor {
    private Professor alterando = null;
    private Professor selected = null;
    private final RepositorioProfessor repositorio = FabricaRepositorio.getFabrica().getRepositorioProfessor();
    
    public ControladorProfessor() {
    }
    
    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Professor p) {
        if(repositorio.existe(p.getId())) {
            repositorio.alterar(p);
        } else {
            repositorio.adicionar(p);
        }
        return "ApresentarProfessor.xhtml";
    }
    
    public void remover(Professor p) {
        repositorio.remover(p);
    }
    
    public void alterar(Professor p) {
        repositorio.alterar(p);
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarProfessor.xhtml";
    }
    public Professor recupearar(long id) {
        return repositorio.recuperar(id);
    }

    public List<Professor> recuperarTodos() {
        return repositorio.recuperar();
    }
    
    public Professor getSelected() {
        return selected;
    }

    public void setSelected(Professor selected) {
        this.selected = selected;
    }

    public Professor getAlterando() {
        return alterando;
    }

    public void setAlterando(Professor alterando) {
        this.alterando = alterando;
    }
}
