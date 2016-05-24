/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.RepositorioQuestao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@SessionScoped
public class ControladorQuestao {
    private RepositorioQuestao repositorio = new RepositorioQuestao();

    public ControladorQuestao() {
    }

    
    public void adicionar(Questao q) {
        repositorio.adicionar(q);
    }

    public void remover(Questao q) {
        repositorio.remover(q);
    }

    public void alterar(Questao q) {
        repositorio.alterar(q);
    }

    public Questao recupearar(long id) {
        return repositorio.recupearar(id);
    }

    public List<Questao> recuperarTodos() {
        return repositorio.recuperarTodos();
    }
   
}
