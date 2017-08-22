/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Professor;
import br.edu.ifpe.garanhuns.provapc.model.dao.FabricaRepositorios;
import br.edu.ifpe.garanhuns.provapc.model.dao.RepositorioGenerico;
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

    RepositorioGenerico<Professor, Integer> repositorio= null;

    public ControladorProfessor() {
        this.repositorio = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.professor, FabricaRepositorios.BD);
    }
    
    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Professor p) {
            repositorio.inserir(p);
        return "ApresentarProfessor.xhtml";
    }
    
    public void remover(Professor p) {
        repositorio.excluir(p);
    }
    
    public void alterar(Professor p) {
        repositorio.alterar(p);
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarProfessor.xhtml";
    }
    public Professor recupearar(int id) {
        return repositorio.recuperar(id);
    }

    public List<Professor> recuperarTodos() {
        return repositorio.recuperarTodos();
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
