/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioAlternativaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioProvaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes.RepositorioQuestaoBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioQuestao;

/**
 *
 * @author lucas
 */
public class RepositorioFabricaBD extends RepositorioFabrica {
    
    protected RepositorioFabricaBD() {
        
    }
    
    private RepositorioProva provas = null;
    private RepositorioQuestao questoes = null;
    private RepositorioAlternativa alternativas = null;
    
    @Override
    public RepositorioProva getRepositorioProva() {
        if(provas==null)
            provas = new RepositorioProvaBD();
        return provas;
    }

    @Override
    public RepositorioAlternativa getRepositorioAlternativa() {
        if(alternativas==null)
            alternativas = new RepositorioAlternativaBD();
        return alternativas;
    }

    @Override
    public RepositorioQuestao getRepositorioQuestao() {
        if(questoes==null)
            questoes = new RepositorioQuestaoBD();
        return questoes;
    }
    
}
