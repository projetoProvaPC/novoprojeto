/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioQuestao {
  private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    public void adicionar(Questao q) {
        dao.persist(q);
    }
    public void remover(Questao q) {
        dao.delete(q);
    }
    public void  alterar(Questao q) {
        dao.update(q);
    }
    public boolean existe(long id) {
        return ! dao.recover("from Questao where id = :id", id).isEmpty();
    }
    public Questao recupearar(long id){
        return (Questao) dao.recover("from Questao where id=:id", id).get(0);
    }
      public List<Questao> recuperarTodos(){
        return DaoManagerHiber.getInstance().recover("from Questao");

    }
}
