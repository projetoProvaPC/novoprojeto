/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlternativaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProvaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioQuestaoMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioUsuarioBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioUsuario;

/**
 *
 * @author lucas
 */
class FabricaRepositorioMemoria extends FabricaRepositorio {

    protected FabricaRepositorioMemoria() {
        
    }
    
    private RepositorioProva provas = null;
    private RepositorioQuestao questoes = null;
    private RepositorioAlternativa alternativas = null;
    private RepositorioUsuario usuario = null;
    
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
    
    @Override
    public RepositorioUsuario getRepositorioUsuario() {
        if(usuario==null)
            usuario = new RepositorioUsuarioBD();
        return usuario;
    }
    
}
