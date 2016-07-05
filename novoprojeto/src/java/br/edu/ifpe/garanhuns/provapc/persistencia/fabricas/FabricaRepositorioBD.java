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
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioUsuarioBD;
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
class FabricaRepositorioBD extends FabricaRepositorio {
    
    protected FabricaRepositorioBD() {
        
    }
    @Override
    public RepositorioProva newRepositorioProva() {
        return new RepositorioProvaBD();
    }

    @Override
    public RepositorioAlternativa newRepositorioAlternativa() {
        return new RepositorioAlternativaBD();
    }

    @Override
    public RepositorioQuestao newRepositorioQuestao() {
        return new RepositorioQuestaoBD();
    }

    @Override
    public RepositorioAluno newRepositorioAluno() {
        return new RepositorioAlunoBD();
    }
    @Override
    public RepositorioProfessor newRepositorioProfessor() {
        return new RepositorioProfessorBD();
    }
    @Override
    public RepositorioUsuario newRepositorioUsuario() {
        return new RepositorioUsuarioBD();
    }
}
