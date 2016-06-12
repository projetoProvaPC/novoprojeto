/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioQuestao;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioQuestaoBD implements RepositorioQuestao {

    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();

    @Override
    public void adicionar(Questao q) {
        dao.persist(q);
    }

    @Override
    public void remover(Questao q) {
        dao.delete(q);
    }

    public void alterar(Questao q) {
        dao.update(q);
    }

    @Override
    public boolean existe(long id) {
        return !dao.recover("from Questao where id = :id", id).isEmpty();
    }

    @Override
    public Questao recuperar(long id) {
        return (Questao) dao.recover("from Questao where id=:id", id).get(0);
    }

    @Override
    public List<Questao> recuperar() {
        return DaoManagerHiber.getInstance().recover("from Questao");
    }

    @Override
    public void remover(long id) {
        Questao q = RepositorioQuestaoBD.this.recuperar(id);
        remover(q);
    }
}
