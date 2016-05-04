/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.aplicacao;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.repositorios.RepositorioProva;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Main {
    public static void main(String[] args) {
        RepositorioProva repositorio = new RepositorioProva();
        Prova p = new Prova();
        Prova c = new Prova();
        repositorio.adicionar(p);
        repositorio.adicionar(c);
        List<Prova> ps = repositorio.recuperarTodos();
        for(Prova p1 : ps) {
            System.out.println(p1);
        }
    }
}
