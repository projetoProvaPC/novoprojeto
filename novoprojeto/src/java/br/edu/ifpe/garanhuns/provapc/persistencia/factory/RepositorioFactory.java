/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.factory;

import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.interfaces.RepositorioProva;

/**
 *
 * @author lucas
 */
public interface RepositorioFactory {
    public RepositorioProva getRepositorioProva();
    //public RepositorioAlternativa getRepositorioAlternativa();
}
