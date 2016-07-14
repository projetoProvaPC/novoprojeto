/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Usuario;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioUsuario;
import java.util.List;

/**
 *
 * @author João Witor
 */
public class RepositorioUsuarioBD implements RepositorioUsuario{
    private final DaoManagerHiber dao = DaoManagerHiber.getInstance();
    
    @Override
    public void adicionar(Usuario u) {
        dao.persist(u);
    }
    @Override
    public void remover(Usuario u) {
        if(u==null) return;
        Usuario toReturn = RepositorioUsuarioBD.this.recuperar(u.getId());
        dao.delete(toReturn);
    }
    public void  alterar(Usuario u) {
        dao.update(u);
    }
    @Override
    public Usuario recuperar(long id){
        return (Usuario) dao.recover("from Usuario where id="+id).get(0);
    }
    @Override
    public List<Usuario> recuperar(){
        return DaoManagerHiber.getInstance().recover("from Usuario");
    }
    @Override
    public void remover(long id) {
        Usuario u = recuperar(id);
        remover(u);
    }
    
}
