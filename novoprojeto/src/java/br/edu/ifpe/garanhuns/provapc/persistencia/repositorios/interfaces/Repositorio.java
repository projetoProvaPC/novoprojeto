/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces;

import java.util.List;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public interface Repositorio<Tipo extends Persistivel> {
    
    public void adicionar(Tipo t) throws IdNaoDisponivelException;
    public Tipo remover(long id);
    public void atualizar(Tipo t);
    public Tipo recuperar(long id);
    public List<Tipo> recuperar();
}
