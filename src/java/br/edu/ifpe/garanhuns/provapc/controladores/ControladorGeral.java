/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;


import br.edu.ifpe.garanhuns.provapc.model.Prova;
import br.edu.ifpe.garanhuns.provapc.model.dao.FabricaRepositorios;
import br.edu.ifpe.garanhuns.provapc.model.dao.RepositorioGenerico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Thais
 */
@ManagedBean
@SessionScoped
public class ControladorGeral {
    
    private ProvaBuilder provaBuilder = new ProvaBuilder();
    RepositorioGenerico<Prova, Integer> repositorio = null;
    
    public ControladorGeral(){
        this.repositorio= FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.prova, FabricaRepositorios.BD);
                
    }
    public ProvaBuilder getProvaBuilder() {
        return provaBuilder;
    }

    public void setProvaBuilder(ProvaBuilder provaBuilder) {
        this.provaBuilder = provaBuilder;
    }
        
     public String finalizarProva() {
         Prova p = provaBuilder.construir();
            repositorio.inserir(p);
         return "CrudProva.xhtml";
    }
    
    public void adicionarQuestao(){
         provaBuilder.addQuestao(new QuestaoBuilder());
         
    }
     
    public void adicionarAlternativa(QuestaoBuilder qb){
         qb.addAlternativa(new AlternativaBuilder());
    }
    
}
