/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

import br.edu.ifpe.garanhuns.provapc.model.Usuario;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioUsuario implements RepositorioGenerico<Usuario, Integer>{
        @Override
    public void inserir(Usuario t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void excluir(Usuario t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public void alterar(Usuario t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Usuario recuperar(Integer g) {
        try {
            return (Usuario) DaoManagerHiber.getInstance().recover("from Usuario where id=" + g).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

@Override
        public List<Usuario> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Usuario");
    }
    
    
}
