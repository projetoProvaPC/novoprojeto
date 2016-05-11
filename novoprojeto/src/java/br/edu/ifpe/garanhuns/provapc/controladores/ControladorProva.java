/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.RepositorioProva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Thais
 */
@ManagedBean(name="ControladorProva")
@SessionScoped
public class ControladorProva {
    private Prova alterando = null;
    private Prova selected = null;
    private RepositorioProva repositorio = new RepositorioProva();

    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Prova p) {
        if(repositorio.existe(p.getId())) {
            repositorio.alterar(p);
        } else {
            repositorio.adicionar(p);
        }
        return "ApresentarProva.xhtml";
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarProva.xhtml";
    }

    public void remover(Prova p) {
        repositorio.remover(p);
    }

    public void alterar(Prova p) {
        repositorio.alterar(p);
    }

    public Prova recupearar(long id) {
        return repositorio.recupearar(id);
    }

    public List<Prova> recuperarTodos() {
        return repositorio.recuperarTodos();
    }

    public Prova getSelected() {
        return selected;
    }

    public void setSelected(Prova selected) {
        this.selected = selected;
    }

    public Prova getAlterando() {
        return alterando;
    }

    public void setAlterando(Prova alterando) {
        this.alterando = alterando;
    }
    
}