/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Thais
 */

public class RepositorioProva {
    
    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    public void adicionar(Prova p) {
        dao.persist(p);
    }
    public void remover(Prova p) {
        dao.delete(p);
    }
    public void  alterar(Prova p) {
        dao.update(p);
    }
    public boolean existe(long id) {
        Prova p = (Prova) dao.recover("from Prova where id=:param", id).get(0);
        return p!=null;
    }
    public Prova recupearar(long id){
        return (Prova) dao.recover("from Prova where id=:param",id).get(0);
    }
      public List<Prova> recuperarTodos(){
        return DaoManagerHiber.getInstance().recover("from Prova");

    }
}
