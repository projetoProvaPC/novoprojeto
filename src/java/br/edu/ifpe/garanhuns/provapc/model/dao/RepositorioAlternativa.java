/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

import br.edu.ifpe.garanhuns.provapc.model.Alternativa;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioAlternativa implements RepositorioGenerico<Alternativa, Integer> {

    @Override
    public void inserir(Alternativa t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void excluir(Alternativa t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public void alterar(Alternativa t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Alternativa recuperar(Integer g) {
        try {
            return (Alternativa) DaoManagerHiber.getInstance().recover("from Alternativa where id=" + g).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;

        }
    }

    @Override
    public List<Alternativa> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Alternativa");
    }

}
