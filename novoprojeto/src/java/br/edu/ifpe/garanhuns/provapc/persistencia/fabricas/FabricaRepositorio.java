/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.fabricas;

import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import br.edu.ifpe.garanhuns.provapc.negocio.Aluno;
import br.edu.ifpe.garanhuns.provapc.negocio.Professor;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Repositorio;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAluno;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProfessor;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioUsuario;

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
    private RepositorioProfessor professores = null;
    private RepositorioAluno alunos = null;
    private RepositorioUsuario usuarios = null;
    
    /**
     * Isso vai lhe dar uma Fábrica de Repositórios.
     * @return uma fábrica de repositórios.
     */
    public static FabricaRepositorio getFabrica() {
        if(fabrica == null) fabrica = new FabricaRepositorioBD(); //m mude aqui!
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
    /**
     * Retorna um Repositório de Professor para você usar.
     * @return um repositório de professor.
     */
    public final RepositorioProfessor getRepositorioProfessor() {
        if(professores==null)
            professores = newRepositorioProfessor();
        return professores;
    }
    /**
     * Retorna um Repositório de Professor para você usar.
     * @return um repositório de professor.
     */
    public final RepositorioAluno getRepositorioAluno() {
        if(alunos==null)
            alunos = newRepositorioAluno();
        return alunos;
    }
    
     public final RepositorioUsuario getRepositorioUsuario(){
        if(usuarios==null)
            usuarios = newRepositorioUsuario();
        return usuarios;
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
    /**
     * Retorna um novo repositório de aluno
     * @return 
     */
    public abstract RepositorioAluno newRepositorioAluno();
    /**
     * Retorna um novo repositório de professor
     * @return repostório professor
     */
    public abstract RepositorioProfessor newRepositorioProfessor();
     /**
     * Retorna um novo repositório de usuario
     * @return repostório usuario
     */
    public abstract RepositorioUsuario newRepositorioUsuario();
    
    /**
     * Retorna um repositório para a classe desejada.
     * @param c a classe desejada
     * @return  o repositório para a classe
     */
    public Repositorio getRepositorio(Class c) {
        if(c==null){
            return null;
        }else if(c.equals(Prova.class)) {
            return this.getRepositorioProva();
        } else if(c.equals(Alternativa.class)) {
            return this.getRepositorioAlternativa();
        } else if(c.equals(Questao.class)) {
            return this.getRepositorioQuestao();
        } else if(c.equals(Professor.class)) {
            return this.getRepositorioProfessor();
        } else if(c.equals(Aluno.class)) {
            return this.getRepositorioAluno();
        } else {
            return null; 
        }
    }
    
}
