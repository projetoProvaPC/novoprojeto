/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.construtores.ProvaBuilder;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Thais
 */
@ManagedBean (eager =true)
@SessionScoped
public class ControladorProva {
    private Prova alterando = null;
    private Prova selected = null;
    private final RepositorioProva repositorio = FabricaRepositorio.getFabrica().getRepositorioProva();
    private ProvaBuilder builder = new ProvaBuilder();
    
    public ControladorProva() {
    }
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
        return repositorio.recuperar(id);
    }

    public List<Prova> recuperarTodos() {
        return repositorio.recuperar();
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
    
    public String getDialogName() {
        if(alterando != null) {
            return "Alterando";
        } else {
            return "Criando";
        }
    }

    public ProvaBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(ProvaBuilder builder) {
        this.builder = builder;
    }
    
    public void criarBuilder() {
        this.setBuilder(new ProvaBuilder());
    }
    
    public void alterarBuilder() {
        this.setBuilder(new ProvaBuilder(this.selected));
    }
    
    public void adicionar() {
        this.adicionar(this.builder.construir());
        criarBuilder();
    }
    
    public String responder(){
        return "ResponderProva.xhtml";
    }
}
