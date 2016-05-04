/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.repositorios;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class RepositorioProvaTest {
    
    public RepositorioProvaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Adiciona um objeto e depois verifica se ele está lá.
     */
    @Test
    public void testAdicionarRecuperarTodos() {
        Prova p = new Prova();
        RepositorioProva instance = new RepositorioProva();
        instance.adicionar(p);
        List<Prova> recuperadas = instance.recuperarTodos();
        assertTrue(recuperadas.contains(p));
    }

    /**
     * Adiciona um objeto, o remove e depois ver se ele não está lá.
     */
    @Test
    public void testAdicionarRemoverRecuperarTodos() {
        RepositorioProva instance = new RepositorioProva();
        Prova p = new Prova();
        
        instance.adicionar(p);
        instance.remover(p);
        
        List<Prova> recuperadas = instance.recuperarTodos();
        assertFalse(recuperadas.contains(p));
    }

    
    /* Teste de alterar
     * Não faz sentido em prova porque prova só tem o atributo ID..
     */

    /**
     * Test of recuperar method, of class RepositorioProva.
     */
    @Test
    public void testAdicionarRecuperarTodosRecupearar() {
        Prova inserida = new Prova();
        RepositorioProva instance = new RepositorioProva();
        instance.adicionar(inserida);
        List<Prova> recuperadas = instance.recuperarTodos();
        Prova recuperada = recuperadas.get(0);
        long id = recuperada.getId();
        assertEquals(recuperada, instance.recupearar(id));
    }

    /*
     * Recuperar todos já foi testado em adicionar e remover
     */
    
}
