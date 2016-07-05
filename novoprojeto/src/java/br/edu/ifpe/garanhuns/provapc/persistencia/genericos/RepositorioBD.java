/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.provapc.persistencia.genericos;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Repositorio;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author lucas
 * @param <T>
 */
public abstract class RepositorioBD<T extends Persistivel> implements Repositorio<T>{

    protected DaoManagerHiber dao = DaoManagerHiber.getInstance();
    private final String name =  ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
    
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
        List recovered = dao.recover("from "+ getClasse() + " where id=" + id);
        if(recovered.isEmpty()) return null;
        return (T) recovered.get(0);
    }

    @Override
    public List<T> recuperar() {
        return (List<T>) dao.recover("from "+ getClasse() );
    }
    
    private String getClasse() {
        return name;
    }
    
}
