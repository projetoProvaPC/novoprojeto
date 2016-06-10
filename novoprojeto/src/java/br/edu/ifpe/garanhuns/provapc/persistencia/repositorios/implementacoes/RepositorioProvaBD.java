/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Hibernate;


/**
 *
 * @author Thais
 */

public class RepositorioProvaBD implements RepositorioProva {
    
    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    public void adicionar(Prova p) {
        dao.persist(p);
    }
    public void remover(Prova p) {
        dao.delete(p);
    }
    public void  atualizar(Prova p) {
        dao.update(p);
    }
    public boolean existe(long id) {
        return ! dao.recover("from Prova where id = :id", id).isEmpty();
    }
    public Prova recuperar(long id){
        return (Prova) dao.recover("from Prova where id=:id",id).get(0);
    }
     
    public List<Prova> recuperar(){
        return DaoManagerHiber.getInstance().recover("from Prova");

    }

    @Override
    public Prova remover(long id) {
        Prova p = this.recuperar(id);
        this.remover(p);
        return p;
    }
}
