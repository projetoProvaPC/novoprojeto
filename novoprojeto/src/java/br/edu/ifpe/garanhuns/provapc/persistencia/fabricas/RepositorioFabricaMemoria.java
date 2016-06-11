/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.factory;

import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioAlternativaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioProvaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioQuestaoMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioQuestao;

/**
 *
 * @author lucas
 */
public class RepositorioFabricaMemoria extends RepositorioFabrica {

    protected RepositorioFabricaMemoria() {
        
    }
    
    private RepositorioProva provas = null;
    private RepositorioQuestao questoes = null;
    private RepositorioAlternativa alternativas = null;
    
    @Override
    public RepositorioProva getRepositorioProva() {
        if(provas==null)
            provas = new RepositorioProvaMemoria();
        return provas;
    }

    @Override
    public RepositorioAlternativa getRepositorioAlternativa() {
        if(alternativas==null)
            alternativas = new RepositorioAlternativaMemoria();
        return alternativas;
    }

    @Override
    public RepositorioQuestao getRepositorioQuestao() {
        if(questoes==null)
            questoes = new RepositorioQuestaoMemoria();
        return questoes;
    }
    
}
