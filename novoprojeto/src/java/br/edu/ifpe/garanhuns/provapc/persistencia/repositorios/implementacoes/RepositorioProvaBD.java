/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Hibernate;


/**
 *
 * @author Thais
 */

public class RepositorioProvaBD implements RepositorioProva {
    
    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void adicionar(Prova p) {
        dao.persist(p);
    }
    @Override
    public void remover(Prova p) {
        dao.delete(p);
    }
    @Override
    public void  alterar(Prova p) {
        dao.update(p);
    }
    @Override
    public boolean existe(long id) {
        return ! dao.recover("from Prova where id = :id", id).isEmpty();
    }
    @Override
    public Prova recuperar(long id){
        return (Prova) dao.recover("from Prova where id=:id",id).get(0);
    }
     
    @Override
    public List<Prova> recuperar(){
        return DaoManagerHiber.getInstance().recover("from Prova");
    }

    @Override
    public void remover(long id) {
        Prova p = this.recuperar(id);
        this.remover(p);
    }
}
