/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioQuestao;

/**
 * Use para conseguir repositórios. Caso queira alterar de Memoria para BD ou outra coisa, mude dentro do método getInstance.
 * @author lucas
 */
public abstract class RepositorioFabrica {
    
    private static RepositorioFabrica fabrica = null;
    protected RepositorioFabrica(){}
    /**
     * Isso vai lhe dar uma Fábrica de Repositórios.
     * @return uma fábrica de repositórios.
     */
    public static RepositorioFabrica getInstance() {
        if(fabrica == null) fabrica = new RepositorioFabricaMemoria();
        return fabrica;
    }
    /**
     * Retorna um repositório para provas
     * @return repositório de provas
     */
    public abstract RepositorioProva getRepositorioProva();
    /**
     * Retorna um repositório para alternativas
     * @return repositório de alternativas
     */
    public abstract RepositorioAlternativa getRepositorioAlternativa();
    /**
     * Retorna um repositório para questões
     * @return repositório para questões.
     */
    public abstract RepositorioQuestao getRepositorioQuestao();
}
