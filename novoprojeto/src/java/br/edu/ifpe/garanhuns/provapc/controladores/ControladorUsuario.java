/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Usuario;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioUsuario;
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
    private final RepositorioUsuario repositorio = FabricaRepositorio.getFabrica().getRepositorioUsuario();
    
    public ControladorUsuario() {
    }
    
    public void remover() {
        remover(selected);
    }
    
     public String adicionar(Usuario a) {
        if(repositorio.existe(a.getId())) {
            repositorio.alterar(a);
        } else {
            repositorio.adicionar(a);
        }
        return "ApresentarUsuario.xhtml";
    }
     
     public String alterar() {
        this.alterando = selected;
        return "CadastrarUsuario.xhtml";
    }
    
    
    public void remover(Usuario a) {
        repositorio.remover(a);
    }

    public void alterar(Usuario a) {
        repositorio.alterar(a);
    }

    public Usuario recuperar(long id) {
        return repositorio.recuperar(id);
    }

    public List<Usuario> recuperarTodos() {
        return repositorio.recuperar();
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
