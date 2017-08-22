/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Aluno;
import br.edu.ifpe.garanhuns.provapc.model.Prova;
import br.edu.ifpe.garanhuns.provapc.model.RespostaProva;
import br.edu.ifpe.garanhuns.provapc.model.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.model.dao.FabricaRepositorios;
import br.edu.ifpe.garanhuns.provapc.model.dao.RepositorioGenerico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Hibernate;

/**
 *
 * @author Thais
 */
@ManagedBean (eager =true)
@SessionScoped
public class ControladorProva {
    private Prova alterando = null;
    private Prova selected = null;
    private ProvaBuilder builder = new ProvaBuilder();
    private ControladorResposta resposta = new ControladorResposta();
    
    RepositorioGenerico<Prova, Integer> repositorio = null;

    public ControladorResposta getResposta() {
        return resposta;
    }

    public void setResposta(ControladorResposta resposta) {
        this.resposta = resposta;
    }
    
    
    public ControladorProva() {
        this.repositorio = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.prova, FabricaRepositorios.BD);
    }
    public void remover() {
        remover(selected);
    }
    
    public String adicionar(Prova p) {
            repositorio.inserir(p);
            this.builder = new ProvaBuilder();
        return "ApresentarProva.xhtml";
    }
    
    public String alterar() {
        this.alterando = selected;
        return "CadastrarProva.xhtml";
    }

    public void remover(Prova p) {
        repositorio.excluir(p);
    }

    public void alterar(Prova p) {
        repositorio.alterar(p);
    }

    public Prova recupearar(int id) {
        return repositorio.recuperar(id);
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
        resposta = new ControladorResposta(selected);
        return "ResponderProva.xhtml";
        
    }
    
    public String retornaPag(){
        return "ResponderQuestao.xhtml";
    }
   
}
