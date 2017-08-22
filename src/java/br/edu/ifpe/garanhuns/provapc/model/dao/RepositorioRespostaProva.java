/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.model.dao;

import br.edu.ifpe.garanhuns.provapc.model.RespostaProva;
import java.util.List;

/**
 *
 * @author Thais
 */
public class RepositorioRespostaProva implements RepositorioGenerico<RespostaProva, Integer>{

    @Override
    public void inserir(RespostaProva t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void excluir(RespostaProva t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public void alterar(RespostaProva t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public RespostaProva recuperar(Integer g) {
        try{
        return (RespostaProva) DaoManagerHiber.getInstance().recover("from RespostaProva where id="+ g).get(0);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
        }

    @Override
    public List<RespostaProva> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from RespostaProva");
    }
    
    
}
