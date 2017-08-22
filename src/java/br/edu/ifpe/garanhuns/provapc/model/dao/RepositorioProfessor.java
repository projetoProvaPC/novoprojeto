/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

import br.edu.ifpe.garanhuns.provapc.model.Professor;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioProfessor implements RepositorioGenerico<Professor, Integer>{
        @Override
    public void inserir(Professor t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void excluir(Professor t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public void alterar(Professor t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Professor recuperar(Integer g) {
        try {
            return (Professor) DaoManagerHiber.getInstance().recover("from Professor where id=" + g).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

@Override
        public List<Professor> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Professor");
    }
    
    
}
