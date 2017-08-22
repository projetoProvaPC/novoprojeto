/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Alternativa;
import br.edu.ifpe.garanhuns.provapc.model.dao.FabricaRepositorios;
import br.edu.ifpe.garanhuns.provapc.model.dao.RepositorioGenerico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author João Witor
 */
@ManagedBean (eager =true)
@SessionScoped
public class ControladorAlternativa {
    private Alternativa alterando = null;
    private Alternativa selected = null;

    RepositorioGenerico<Alternativa, Integer> repositorio= null;
    
    public ControladorAlternativa(){
        this.repositorio = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.alternativa, FabricaRepositorios.BD);
    }
   
    
    public void remover() {
        remover(selected);
    }
    
     public String adicionar(Alternativa a) {
            repositorio.inserir(a);
        return "ApresentarAlternativa.xhtml";
    }
     
     public String alterar() {
        this.alterando = selected;
        return "CadastrarAlternativa.xhtml";
    }
    
    
    public void remover(Alternativa a) {
        repositorio.excluir(a);
    }

    public void alterar(Alternativa a) {
        repositorio.alterar(a);
    }

    public Alternativa recuperar(int id) {
        return repositorio.recuperar(id);
    }

    public List<Alternativa> recuperarTodos() {
        return repositorio.recuperarTodos();
    }

    public Alternativa getSelected() {
        return selected;
    }

    public void setSelected(Alternativa selected) {
        this.selected = selected;
    }

    public Alternativa getAlterando() {
        return alterando;
    }

    public void setAlterando(Alternativa alterando) {
        this.alterando = alterando;
    }
}
