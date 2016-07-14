/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlternativaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlunoMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProfessorMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProvaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioQuestaoMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioUsuarioBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioUsuarioMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAluno;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProfessor;
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
    
    @Override
    public RepositorioProva newRepositorioProva() {
        return new RepositorioProvaMemoria();
    }

    @Override
    public RepositorioAlternativa newRepositorioAlternativa() {
        return new RepositorioAlternativaMemoria();
    }

    @Override
    public RepositorioQuestao newRepositorioQuestao() {
        return new RepositorioQuestaoMemoria();
    }
    @Override
    public RepositorioAluno newRepositorioAluno() {
        return new RepositorioAlunoMemoria();
    }

    @Override
    public RepositorioProfessor newRepositorioProfessor() {
        return new RepositorioProfessorMemoria();
    }
    
    @Override
    public RepositorioUsuario newRepositorioUsuario() {
        return new RepositorioUsuarioMemoria();
    }
}
