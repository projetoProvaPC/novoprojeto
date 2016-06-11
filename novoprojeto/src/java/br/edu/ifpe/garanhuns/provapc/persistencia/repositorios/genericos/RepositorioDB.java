/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.genericos;

import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.Persistivel;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.Repositorio;
import java.util.List;

/**
 *
 * @author lucas
 * @param <T>
 */
public abstract class RepositorioDB<T extends Persistivel> implements Repositorio<T>{

    protected DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void adicionar(T t){
        dao.persist(t);
    }

    @Override
    public void remover(long id) {
        T t = recuperar(id);
        dao.delete(t);
    }

    @Override
    public void alterar(T t) {
        dao.update(t);
    }

    @Override
    public T recuperar(long id) {
        return (T) dao.recover("from "+ getClasse() + " where id=" + id).get(0);
    }

    @Override
    public List<T> recuperar() {
        return (List<T>) dao.recover("from "+ getClasse() );
    }
    
    protected abstract String getClasse();
    
}
