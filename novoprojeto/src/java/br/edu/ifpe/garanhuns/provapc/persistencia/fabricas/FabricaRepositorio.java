/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;

/**
 * Use para conseguir repositórios. Caso queira alterar de Memoria para BD ou outra coisa, mude dentro do método getInstance.
 * @author lucas
 */
public abstract class FabricaRepositorio {
    
    private static FabricaRepositorio fabrica = null;
    protected FabricaRepositorio(){}
    
    // os objetos =D
    private RepositorioProva provas = null;
    private RepositorioQuestao questoes = null;
    private RepositorioAlternativa alternativas = null;
    
    /**
     * Isso vai lhe dar uma Fábrica de Repositórios.
     * @return uma fábrica de repositórios.
     */
    public static FabricaRepositorio getFabrica() {
        if(fabrica == null) fabrica = new FabricaRepositorioMemoria(); //m mude aqui!
        return fabrica;
    }
    
    //  Métodos públicos
    /**
     * Retorna o repositório de prova
     * @return o repositório de prova
     */
    public final RepositorioProva getRepositorioProva() {
        if(provas == null)
            provas = newRepositorioProva();
        return provas;
    }
    /**
     * Retorna o repositório de prova
     * @return o repositório de prova
     */
    public final RepositorioQuestao getRepositorioQuestao() {
        if(questoes == null)
            questoes = newRepositorioQuestao();
        return questoes;
    }
    /**
     * Retorna o repositório de prova
     * @return o repositório de prova
     */
    public final RepositorioAlternativa getRepositorioAlternativa() {
        if(alternativas == null)
            alternativas = newRepositorioAlternativa();
        return alternativas;
    }
    
    // Métodos abstratos (protegidos)
    /**
     * Retorna um repositório para provas novo
     * @return repositório de provas
     */
    protected abstract RepositorioProva newRepositorioProva();
    /**
     * Retorna um repositório para alternativas novo
     * @return repositório de alternativas
     */
    protected abstract RepositorioAlternativa newRepositorioAlternativa();
    /**
     * Retorna um repositório para questões novo
     * @return repositório para questões.
     */
    protected abstract RepositorioQuestao newRepositorioQuestao();
    
}
