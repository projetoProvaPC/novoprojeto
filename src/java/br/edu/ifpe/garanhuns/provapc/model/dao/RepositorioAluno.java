/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

import br.edu.ifpe.garanhuns.provapc.model.Aluno;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioAluno implements RepositorioGenerico<Aluno, Integer>{
        @Override
    public void inserir(Aluno t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void excluir(Aluno t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public void alterar(Aluno t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Aluno recuperar(Integer g) {
        try {
            return (Aluno) DaoManagerHiber.getInstance().recover("from Aluno where id=" + g).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

@Override
        public List<Aluno> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Aluno");
    }
    
    
}
