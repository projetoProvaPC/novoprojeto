/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioIT;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Só testa o sucesso por enquanto...
 * @author lucas
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class RepositorioProvaBDITest {
    
    private static RepositorioIT<Prova> tester = null;

    @BeforeClass
    public static void setup () {
        tester = new RepositorioIT<>();
        tester.repositorio = new RepositorioProvaBD();
    }
    
    @Test
    public void testAAdicionar() {
        tester.t1 = new Prova("Primeira Prova");
        tester.testAAdicionar();
    }

    @Test
    public void testBPosAdicionarRecuperarTodos() {
        tester.testBPosAdicionarRecuperarTodos();
    }

    @Test
    public void testCPosAdicionarExisteId() {
        tester.testCPosAdicionarExisteId();
    }

    @Test
    public void testDPosAdicionarExisteObject() {
        tester.testDPosAdicionarExisteObject();
    }

    @Test
    public void testEPosAdicionarRecuperarId() {
        tester.testEPosAdicionarRecuperarId();
    }

    @Test
    public void testFAlterar() {
        tester.t1.setTitulo("Primiera Prova Alterada");
        tester.testFAlterar();
    }

    @Test
    public void testGPosAlterarRecuperarId() {
        tester.testGPosAlterarRecuperarId();
    }

    @Test
    public void testHRemoverId() {
        tester.testHRemoverId();
    }

    @Test
    public void testIPosRemoverIdExisteId() {
        tester.testIPosRemoverIdExisteId();
    }

    @Test
    public void testJAdicionar2() {
        tester.t1 = new Prova("Segunda Prova");
        tester.testJAdicionar2();
    }

    @Test
    public void testKPosAdicionar2RecuperarTodos() {
        tester.testKPosAdicionar2RecuperarTodos();
    }

    @Test
    public void testLRemoverObject() {
        tester.testLRemoverObject();
    }

    @Test
    public void testMPosRemoverExisteObject() {
        tester.testMPosRemoverExisteObject();
    }
    
}
