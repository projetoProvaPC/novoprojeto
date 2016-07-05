/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlternativaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProvaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioQuestaoBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioUsuarioBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioUsuario;

/**
 *
 * @author lucas
 */
class FabricaRepositorioBD extends FabricaRepositorio {
    
    protected FabricaRepositorioBD() {
        
    }
    
    private RepositorioProva provas = null;
    private RepositorioQuestao questoes = null;
    private RepositorioAlternativa alternativas = null;
    private RepositorioUsuario usuario = null;
    
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
    
     @Override
    public RepositorioUsuario getRepositorioUsuario() {
        if(usuario==null)
            usuario = new RepositorioUsuarioBD();
        return usuario;
    }
}
