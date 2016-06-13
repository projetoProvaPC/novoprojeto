/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlternativaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlunoBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProfessorBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProvaBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioQuestaoBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAluno;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProfessor;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;

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
    private RepositorioAluno alunos = null;
    private RepositorioProfessor professores = null;
    
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
    public RepositorioAluno getRepositorioAluno() {
        if(alunos==null)
            alunos = new RepositorioAlunoBD();
        return alunos;
    }
    @Override
    public RepositorioProfessor getRepositorioProfessor() {
        if(professores==null)
            professores = new RepositorioProfessorBD();
        return professores;
    }
}