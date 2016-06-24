/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.RepositorioProva;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Só testa o sucesso por enquanto...
 * @author lucas
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class RepositorioProvaBDITest {
    
    private RepositorioProva repositorio = new RepositorioProvaBD();
    private Prova p1 = new Prova("Primeira prova");
    private Prova p2 = null;
    private Prova p3 = null;
    private Prova p4 = new Prova("Segunda prova");
    private Prova p5 = null;
    
    /**
     * Adicionar
     */
    @Test
    public void testAAdicionar() {
        repositorio.adicionar(p1);
    }
    
    /**
     * Recuperar Todos depois de Adicionar
     */
    @Test
    public void testBPosAdicionarRecuperarTodos() {
        List<Prova> recuperar = repositorio.recuperar();
        boolean found = false;
        for(Prova p : recuperar){
            if(p.getTitulo().equals(p1.getTitulo())){
                found = true;
                p1 = p;  // será usado no próximo método
                assertEquals(p.getTitulo(), p1.getTitulo());
                break;
            }
        }
        if(!found) {
            fail("Not found");
        }
    }
    
    /**
     * Verifica se existe pelo id recuperado no testBPosAdicionarRecuperarTodos
     */
    @Test
    public void testCPosAdicionarExisteId() {
        long id = p1.getId();
        assertTrue(repositorio.existe(id));
    }
    
    /**
     * Verifica se existe o objeto recuperado no testBPosAdicionarRecuperarTodos
     */
    @Test
    public void testDPosAdicionarExisteObject() {
        assertTrue(repositorio.existe(p1));
    }
    
    /**
     * Tenta recuperar por id o objeto adicionado
     */
    @Test
    public void testEPosAdicionarRecuperarId() {
        long id = p1.getId();
        p2 = repositorio.recuperar(id);
        assertNotNull(p2);
        assertEquals(p2.getTitulo(), p1.getTitulo());
        assertEquals(p2.getId(), p1.getId());
    }
    
    /**
     * 
     */
    @Test
    public void testFAlterar() {
        p1.setTitulo("Primeira Prova Atualizado");
        repositorio.alterar(p1);
    }
    
    /**
     * Tenta recuperar todos e achar depois da alterar
     */
    @Test
    public void testGPosAlterarRecuperarTodos() {
        List<Prova> recuperar = repositorio.recuperar();
        boolean found = false;
        for(Prova p : recuperar){
            if(p.getTitulo().equals(p1.getTitulo())){
                found = true;
                assertEquals(p.getTitulo(), p1.getTitulo());
                assertEquals(p.getId(), p1.getId());
                p1 = p;  // será usado no próximo método
            }
        }
        if(!found) {
            fail("Not found");
        }
    }
    
    /**
     * Tenta recuperar o que foi alterado pelo id
     */
    @Test
    public void testHPosAlterarRecuperarId() {
        long id = p1.getId();
        p2 = repositorio.recuperar(id);
        assertNotNull(p2);
        assertEquals(p2.getTitulo(), p1.getTitulo());
        assertEquals(p2.getId(), p1.getId());
    }
    
    /**
     * Agora remove
     */
    @Test 
    public void testIRemoverId() {
        assertNotNull(p2);
        long id = p2.getId();
        repositorio.remover(id);
    }
    
    /**
     * Não pode encontrar por id
     */
    @Test
    public void testJPosRemoverIdExisteId() {
        assertNotNull(p2);
        long id = p2.getId();
        assertNull(repositorio.recuperar(id));
    }
    
    /**
     * Adiciono outro
     */
    @Test
    public void testKAdicionar2() {
        p1 = new Prova("Segunda prova");
        repositorio.adicionar(p1);
    }
    
    /**
     * Recuperar Todos depois de Adicionar de novo
     */
    @Test
    public void testLPosAdicionar2RecuperarTodos() {
        List<Prova> recuperar = repositorio.recuperar();
        boolean found = false;
        for(Prova p : recuperar){
            if(p.getTitulo().equals(p1.getTitulo())){
                found = true;
                assertEquals(p.getTitulo(), p1.getTitulo());
                p1 = p;  // será usado no próximo método
            }
        }
        if(!found) {
            fail("Not found");
        }
    }
    
    @Test
    public void testMRemoverObject() {
        repositorio.remover(p1);
    }
    
    @Test
    public void testNPosRemoverExisteObject() {
        assertFalse(repositorio.existe(p1));
    }
    
}
