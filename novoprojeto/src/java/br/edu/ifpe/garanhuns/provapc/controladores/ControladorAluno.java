/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Aluno;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAluno;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@SessionScoped
public class ControladorAluno {
    private Aluno alterando = null;
    private Aluno selected = null;
    private final RepositorioAluno repositorio = FabricaRepositorio.getFabrica().getRepositorioAluno();
    
    public ControladorAluno() {
    }
    
    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Aluno a) {
        if(repositorio.existe(a.getId())) {
            repositorio.alterar(a);
        } else {
            repositorio.adicionar(a);
        }
        return "ApresentarAluno.xhtml";
    }
    
    public void remover(Aluno a) {
        repositorio.remover(a);
    }
    
    public void alterar(Aluno a) {
        repositorio.alterar(a);
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarAluno.xhtml";
    }
    public Aluno recupearar(long id) {
        return repositorio.recuperar(id);
    }

    public List<Aluno> recuperarTodos() {
        return repositorio.recuperar();
    }
    
    public Aluno getSelected() {
        return selected;
    }

    public void setSelected(Aluno selected) {
        this.selected = selected;
    }

    public Aluno getAlterando() {
        return alterando;
    }

    public void setAlterando(Aluno alterando) {
        this.alterando = alterando;
    }
}
