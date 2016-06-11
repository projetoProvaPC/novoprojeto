/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.construtores.ProvaBuilder;
import br.edu.ifpe.garanhuns.provapc.construtores.QuestaoBuilder;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioProvaBD;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Thais
 */
@ManagedBean
public class ControladorGeral {
    
    private ProvaBuilder prova = new ProvaBuilder();
    private RepositorioProvaBD repositorio = new RepositorioProvaBD();
    
    public List<QuestaoBuilder> getQuestoes() {
        return prova.getQuestoes();
    }
    
    
     public String finalizarProva(Prova p) {
        if(repositorio.existe(p.getId())) {
            repositorio.atualizar(p);
        } else {
            repositorio.adicionar(p);
        }
         return "ApresentarProva.xhtml";
    }
}
