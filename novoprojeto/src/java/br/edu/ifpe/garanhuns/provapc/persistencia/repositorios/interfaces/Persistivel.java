/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces;

import java.io.Serializable;

/**
 *
 * Essa interface descreve objetos que podem ser salvos em Repositórios.
 * @see Repositorio
 * 
 * @author lucas
 * @param <Tipo> em geral, o mesmo tipo da classe alguma classe/interface que ela herda
 */
public interface Persistivel<Tipo> extends Serializable {
    /**
     * Altera o id do objeto.
     * @param id o novo id do objeto.
     */
    public void setId(long id);
    /**
     * Retorna o id do objeto
     * @return o id atual do objeto.
     */
    public long getId();
    /**
     * Copia os valores de todas as variáveis de instância de t para as variáveis de this.
     * @param t uma versão atualizada do objeto
     */
    public void alterar(Tipo t);
    /**
     * Cria uma cópia independente do objeto.
     * @return uma cópia do objeto.
     */
    public Tipo copiar();
}