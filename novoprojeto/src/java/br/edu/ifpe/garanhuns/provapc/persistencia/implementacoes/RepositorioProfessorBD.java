/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Professor;
import br.edu.ifpe.garanhuns.provapc.persistencia.genericos.RepositorioBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProfessor;

/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
public class RepositorioProfessorBD extends RepositorioBD<Professor> implements RepositorioProfessor{

    @Override
    protected String getClasse() {
        return "Professor";
    }
    
}
