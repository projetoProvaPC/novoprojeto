/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.aplicacao;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.RepositorioProva;

/**
 *
 * @author lucas
 */
public class Main {
    public static void main(String[] args) {
        RepositorioProva repositorio = new RepositorioProva();
        Prova p = new Prova();
        repositorio.adicionar(p);
    }
}
