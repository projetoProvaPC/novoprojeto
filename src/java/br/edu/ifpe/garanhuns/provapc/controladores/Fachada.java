/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Alternativa;
import br.edu.ifpe.garanhuns.provapc.model.Aluno;
import br.edu.ifpe.garanhuns.provapc.model.Professor;
import br.edu.ifpe.garanhuns.provapc.model.Prova;
import br.edu.ifpe.garanhuns.provapc.model.Questao;
import br.edu.ifpe.garanhuns.provapc.model.RespostaProva;
import br.edu.ifpe.garanhuns.provapc.model.Usuario;
import br.edu.ifpe.garanhuns.provapc.model.dao.FabricaRepositorios;
import br.edu.ifpe.garanhuns.provapc.model.dao.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author Thais
 */
public class Fachada {
    private static Fachada myself= null;
    
    private RepositorioGenerico<Questao, Integer> repositorioQuestao=null;
    private RepositorioGenerico<Alternativa, Integer> repositorioAlternativa=null;
    private RepositorioGenerico<Prova, Integer> repositorioProva=null;
    private RepositorioGenerico<Professor, Integer> repositorioProfessor=null;
    private RepositorioGenerico<Aluno, Integer> repositorioAluno=null;
    private RepositorioGenerico<Usuario, Integer> repositorioUsuario=null;
    private RepositorioGenerico<RespostaProva, Integer> repositorioRespostaProva=null;

    
    
    private Fachada(){
        this.repositorioAlternativa = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.alternativa, FabricaRepositorios.BD);
        this.repositorioQuestao = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.questao, FabricaRepositorios.BD);
        this.repositorioProva = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.prova, FabricaRepositorios.BD);
        this.repositorioProfessor = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.professor, FabricaRepositorios.BD);
        this.repositorioAluno = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.aluno, FabricaRepositorios.BD);
        this.repositorioUsuario = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.usuario, FabricaRepositorios.BD);
        this.repositorioRespostaProva = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.respostaProva, FabricaRepositorios.BD);
    }
    
    public static Fachada getInstance() {
        if (myself == null) {
            myself = new Fachada();
        }
        return myself;
    }
    
    
    public void inserirAlternativa(Alternativa alternativa){
        this.repositorioAlternativa.inserir(alternativa);
    }
    
    public void alterarAlternativa(Alternativa alternativa){
        this.repositorioAlternativa.alterar(alternativa);
    }
    
    public void excluirAlternativa(Alternativa alternativa){
        this.repositorioAlternativa.excluir(alternativa);
    }
    
    public Alternativa recuperarAlternativa(int id){
        return this.repositorioAlternativa.recuperar(id);
    }
    
    public List<Alternativa> recuperarAlternativas(int id){
        return this.repositorioAlternativa.recuperarTodos();
    }
    
    
    public void inserirQuestao(Questao questao){
        this.repositorioQuestao.inserir(questao);
    }
    
    public void alterarQuestao(Questao questao){
        this.repositorioQuestao.alterar(questao);
    }
    
    public void excluirQuestao(Questao questao){
        this.repositorioQuestao.excluir(questao);
    }
    
    public Questao recuperarQuestao(int id){
        return this.repositorioQuestao.recuperar(id);
    }
    
    public List<Questao> recuperarQuestoes(int id){
        return this.repositorioQuestao.recuperarTodos();
    }
    
    
    
    public void inserirProva(Prova prova){
        this.repositorioProva.inserir(prova);
    }
    
    public void alterarProva(Prova prova){
        this.repositorioProva.alterar(prova);
    }
    
    public void excluirProva(Prova prova){
        this.repositorioProva.excluir(prova);
    }
    
    public Prova recuperarProva(int id){
        return this.repositorioProva.recuperar(id);
    }
    
    public List<Prova> recuperarProvas(int id){
        return this.repositorioProva.recuperarTodos();
    }
    
    
    public void inserirProfessor(Professor professor){
        this.repositorioProfessor.inserir(professor);
    }
    
    public void alterarProfessor(Professor professor){
        this.repositorioProfessor.alterar(professor);
    }
    
    public void excluirProfessor(Professor professor){
        this.repositorioProfessor.excluir(professor);
    }
    
    public Professor recuperarProfessor(int id){
        return this.repositorioProfessor.recuperar(id);
    }
    
    public List<Professor> recuperarProfessores(int id){
        return this.repositorioProfessor.recuperarTodos();
    }
    
    
    public void inserirAluno(Aluno aluno){
        this.repositorioAluno.inserir(aluno);
    }
    
    public void alterarAluno(Aluno aluno){
        this.repositorioAluno.alterar(aluno);
    }
    
    public void excluirAluno(Aluno aluno){
        this.repositorioAluno.excluir(aluno);
    }
    
    public Aluno recuperarAluno(int id){
        return this.repositorioAluno.recuperar(id);
    }
    
    public List<Aluno> recuperarAlunos(int id){
        return this.repositorioAluno.recuperarTodos();
    }
    
    
    public void inserirUsuario(Usuario usuario){
        this.repositorioUsuario.inserir(usuario);
    }
    
    public void alterarUsuario(Usuario usuario){
        this.repositorioUsuario.alterar(usuario);
    }
    
    public void excluirUsuario(Usuario usuario){
        this.repositorioUsuario.excluir(usuario);
    }
    
    public Usuario recuperarUsuario(int id){
        return this.repositorioUsuario.recuperar(id);
    }
    
    public List<Usuario> recuperarUsuarios(int id){
        return this.repositorioUsuario.recuperarTodos();
    }
    
    public void inserirRespostaProva(RespostaProva respostaProva){
        this.repositorioRespostaProva.inserir(respostaProva);
    }
    
    public void alterarRespostaProva(RespostaProva respostaProva){
        this.repositorioRespostaProva.alterar(respostaProva);
    }
    
    public void excluirRespostaProva(RespostaProva respostaProva){
        this.repositorioRespostaProva.excluir(respostaProva);
    }
    
    public RespostaProva recuperarRespostaProva(int id){
        return this.repositorioRespostaProva.recuperar(id);
    }
    
    public List<RespostaProva> recuperarRespostasProvas(int id){
        return this.repositorioRespostaProva.recuperarTodos();
    }
    
    
   
}
