/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;


import br.edu.ifpe.garanhuns.provapc.construtores.AlternativaBuilder;
import br.edu.ifpe.garanhuns.provapc.construtores.ProvaBuilder;
import br.edu.ifpe.garanhuns.provapc.construtores.QuestaoBuilder;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
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
    private RepositorioProva repositorio = FabricaRepositorio.getFabrica().getRepositorioProva();

    public ProvaBuilder getProvaBuilder() {
        return provaBuilder;
    }

    public void setProvaBuilder(ProvaBuilder provaBuilder) {
        this.provaBuilder = provaBuilder;
    }
        
     public String finalizarProva() {
         Prova p = provaBuilder.construir();
        if(repositorio.existe(p.getId())) {
            repositorio.alterar(p);
        } else {
            repositorio.adicionar(p);
        }
         return "ApresentarProva.xhtml";
    }
     public void adicionarQuestao(){
         provaBuilder.addQuestao(new QuestaoBuilder());
         
     }
     
     public void adicionarAlternativa(){
         provaBuilder.addAlternativa(new AlternativaBuilder());
     }
}
