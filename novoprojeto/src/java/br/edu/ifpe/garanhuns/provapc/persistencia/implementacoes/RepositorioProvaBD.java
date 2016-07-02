/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.genericos.RepositorioBD;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Hibernate;


/**
 *
 * @author Thais
 */

public class RepositorioProvaBD extends RepositorioBD<Prova> implements RepositorioProva {
    
}
