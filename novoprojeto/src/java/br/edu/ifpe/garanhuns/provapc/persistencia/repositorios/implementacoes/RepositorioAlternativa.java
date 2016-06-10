/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author LUCINALDO
 */
public class RepositorioAlternativa {
    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    public void adicionar(Alternativa a) {
        dao.persist(a);
    }
    public void remover(Alternativa a) {
        dao.delete(a);
    }
    public void  alterar(Alternativa a) {
        dao.update(a);
    }
    public Alternativa recupearar(long id){
        return (Alternativa) dao.recover("from Alternativa where id="+id).get(0);
    }
    public List<Alternativa> recuperarTodos(){
        return DaoManagerHiber.getInstance().recover("from Alternativa");
    }
}
