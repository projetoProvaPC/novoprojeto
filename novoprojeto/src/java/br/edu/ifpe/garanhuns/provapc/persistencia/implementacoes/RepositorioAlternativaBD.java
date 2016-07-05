/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioAlternativa;
import java.util.List;

/**
 *
 * @author João Witor
 */
public class RepositorioAlternativaBD implements RepositorioAlternativa {
    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void adicionar(Alternativa a) {
        dao.persist(a);
    }
    @Override
    public void remover(Alternativa a) {
        if(a==null) return;
        Alternativa toReturn = RepositorioAlternativaBD.this.recuperar(a.getId());
        dao.delete(toReturn);
    }
    public void  alterar(Alternativa a) {
        dao.update(a);
    }
    @Override
    
    public Alternativa recuperar(long id){
        return (Alternativa) dao.recover("from Alternativa where id="+id).get(0);
    }
    @Override
    public List<Alternativa> recuperar(){
        return DaoManagerHiber.getInstance().recover("from Alternativa");
    }
    @Override
    public void remover(long id) {
        Alternativa a = recuperar(id);
        remover(a);
    }
}
