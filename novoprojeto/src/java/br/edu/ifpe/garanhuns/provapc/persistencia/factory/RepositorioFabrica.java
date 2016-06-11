/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.factory;

import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioQuestao;

/**
 *
 * @author lucas
 */
public abstract class RepositorioFabrica {
    
    private static RepositorioFabrica fabrica = null;
    protected RepositorioFabrica(){}
    public RepositorioFabrica getInstance() {
        if(fabrica == null) fabrica = new RepositorioFabricaMemoria();
        return fabrica;
    }
    
    public abstract RepositorioProva getRepositorioProva();
    public abstract RepositorioAlternativa getRepositorioAlternativa();
    public abstract RepositorioQuestao getRepositorioQuestao();
}
