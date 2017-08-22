/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

import br.edu.ifpe.garanhuns.provapc.model.Prova;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioProva implements RepositorioGenerico<Prova, Integer>{
        @Override
    public void inserir(Prova t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void excluir(Prova t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public void alterar(Prova t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Prova recuperar(Integer g) {
        try {
            return (Prova) DaoManagerHiber.getInstance().recover("from Prova where id=" + g).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

@Override
        public List<Prova> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Prova");
    }
    
    
}
