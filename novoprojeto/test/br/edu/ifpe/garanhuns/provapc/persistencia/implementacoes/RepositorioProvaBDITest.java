/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.dao.DaoManagerHiber;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Só testa o sucesso por enquanto...
 * @author lucas
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class RepositorioProvaBDITest {
    
    public static RepositorioProva repositorio = null;
    public static Prova prova = null;
    
    @BeforeClass
    public static void preparar() {
        // TODO seria bom apagar a tabela!
        repositorio = new RepositorioProvaBD();
    }
    
    /**
     * Adicionar
     */
    @Test
    public void testAAdicionar() {
        prova = new Prova("Primeira prova");
        repositorio.adicionar(prova);
    }
    
    /**
     * Recuperar Todos depois de Adicionar
     */
    @Test
    public void testBPosAdicionarRecuperarTodos() {
        assertNotNull(prova);
        List<Prova> recuperar = repositorio.recuperar();
        for(Prova p : recuperar){
            if(prova.getTitulo().equals(p.getTitulo())){
                assertEquals(p.getTitulo(), prova.getTitulo());
                prova = p;  // será usado no próximo método
                return;
            }
        }
        fail("Not found");
    }
    
    /**
     * Verifica se existe pelo id recuperado no testBPosAdicionarRecuperarTodos
     */
    @Test
    public void testCPosAdicionarExisteId() {
        assertNotNull(prova);
        long id = prova.getId();
        assertTrue(repositorio.existe(id));
    }
    
    /**
     * Verifica se existe o objeto recuperado no testBPosAdicionarRecuperarTodos
     */
    @Test
    public void testDPosAdicionarExisteObject() {
        assertNotNull(prova);
        assertTrue(repositorio.existe(prova));
    }
    
    /**
     * Tenta recuperar por id o objeto adicionado
     */
    @Test
    public void testEPosAdicionarRecuperarId() {
        assertNotNull(prova);
        long id = prova.getId();
        Prova p = repositorio.recuperar(id);
        assertNotNull(p);
        assertEquals(p.getTitulo(), prova.getTitulo());
        assertEquals(p.getId(), prova.getId());
    }
    
    /**
     * 
     */
    @Test
    public void testFAlterar() {
        assertNotNull(prova);
        prova.setTitulo("Primeira Prova Atualizado");
        repositorio.alterar(prova);
    }
    
    /**
     * Tenta recuperar o que foi alterado pelo id
     */
    @Test
    public void testGPosAlterarRecuperarId() {
        assertNotNull(prova);
        long id = prova.getId();
        Prova p = repositorio.recuperar(id);
        assertNotNull(p);
        assertEquals(p.getTitulo(), prova.getTitulo());
        assertEquals(p.getId(), prova.getId());
    }
    
    /**
     * Agora remove
     */
    @Test 
    public void testHRemoverId() {
        assertNotNull(prova);
        long id = prova.getId();
        repositorio.remover(id);
    }
    
    /**
     * Não pode encontrar por id
     */
    @Test
    public void testIPosRemoverIdExisteId() {
        assertNotNull(prova);
        long id = prova.getId();
        assertNull(repositorio.recuperar(id));
    }
    
    /**
     * Adiciono outro
     */
    @Test
    public void testJAdicionar2() {
        prova = new Prova("Segunda prova");
        repositorio.adicionar(prova);
    }
    
    /**
     * Recuperar Todos depois de Adicionar de novo
     */
    @Test
    public void testKPosAdicionar2RecuperarTodos() {
        assertNotNull(prova);
        List<Prova> recuperar = repositorio.recuperar();
        for(Prova p : recuperar){
            if(p.getTitulo().equals(prova.getTitulo())){
                assertEquals(p.getTitulo(), prova.getTitulo());
                prova = p;  // será usado no próximo método
                return;
            }
        }
        prova=null;
        fail("Not found");
    }
    
    @Test
    public void testLRemoverObject() {
        assertNotNull(prova);
        repositorio.remover(prova);
    }
    
    @Test
    public void testMPosRemoverExisteObject() {
        assertNotNull(prova);
        assertFalse(repositorio.existe(prova));
    }
    
}
