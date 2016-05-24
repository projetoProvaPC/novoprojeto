/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.RepositorioAlternativa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 20131E12GR0178
 */
@ManagedBean
@SessionScoped
public class ControladorAlternativa {
   private RepositorioAlternativa repositorio = new RepositorioAlternativa();

    public void adicionar(Alternativa q) {
        repositorio.adicionar(q);
    }

    public void remover(Alternativa q) {
        repositorio.remover(q);
    }

    public void alterar(Alternativa q) {
        repositorio.alterar(q);
    }

    public Alternativa recupearar(long id) {
        return repositorio.recupearar(id);
    }

    public List<Alternativa> recuperarTodos() {
        return repositorio.recuperarTodos();
    }
}
