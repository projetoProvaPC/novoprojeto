/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Usuario;
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
public class ControladorUsuario {
    private Usuario alterando = null;
    private Usuario selected = null;

    RepositorioGenerico<Usuario, Integer> repositorio = null;
    
    public ControladorUsuario() {
        this.repositorio= FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.usuario, FabricaRepositorios.BD);
    }
    
    public void remover() {
        remover(selected);
    }
    
     public String adicionar(Usuario a) {
            repositorio.inserir(a);
        return "ApresentarUsuario.xhtml";
    }
     
     public String alterar() {
        this.alterando = selected;
        return "CadastrarUsuario.xhtml";
    }
    
    
    public void remover(Usuario a) {
        repositorio.excluir(a);
    }

    public void alterar(Usuario a) {
        repositorio.alterar(a);
    }

    public Usuario recuperar(int id) {
        return repositorio.recuperar(id);
    }

    public List<Usuario> recuperarTodos() {
        return repositorio.recuperarTodos();
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    public Usuario getAlterando() {
        return alterando;
    }

    public void setAlterando(Usuario alterando) {
        this.alterando = alterando;
    }
}
