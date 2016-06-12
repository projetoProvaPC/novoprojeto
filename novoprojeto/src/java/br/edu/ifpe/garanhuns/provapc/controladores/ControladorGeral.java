/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.construtores.ProvaBuilder;
import br.edu.ifpe.garanhuns.provapc.construtores.QuestaoBuilder;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProvaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Thais
 */
@ManagedBean
public class ControladorGeral {
    
    private ProvaBuilder provaBuilder = new ProvaBuilder();
    private RepositorioProva repositorio = FabricaRepositorio.getFabrica().getRepositorioProva();
    
    public List<QuestaoBuilder> getQuestoes() {
        return provaBuilder.getQuestoes();
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
         provaBuilder.getQuestoes().add(new QuestaoBuilder());
         
     }
}
