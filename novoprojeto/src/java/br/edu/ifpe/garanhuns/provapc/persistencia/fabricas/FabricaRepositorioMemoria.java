/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioAlternativaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioProvaMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioQuestaoMemoria;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;

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
    
}
